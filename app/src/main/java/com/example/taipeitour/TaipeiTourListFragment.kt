package com.example.taipeitour

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeitour.databinding.TaipeiTourListFragmentBinding
import com.example.taipeitour.model.DataItem
import com.example.taipeitour.network.Config
import com.example.taipeitourimport.TaipeiTourListAdapter
import kotlinx.coroutines.NonDisposableHandle.parent
import okhttp3.internal.cacheGet
import retrofit2.Callback

class TaipeiTourListFragment : Fragment(), TaipeiTourListContract.View,
    TaipeiTourListAdapter.CustomListeners {

    private lateinit var binding: TaipeiTourListFragmentBinding
    private var page = 1
    private var language = "zh-tw"
    private val taipeiTourAdapter by lazy {
        TaipeiTourListAdapter(this)
    }
    private val presenter: TaipeiTourListContract.Presenter? by lazy {
        TaipeiTourListPresenter(this)
    }


    companion object {
        fun newInstance(): TaipeiTourListFragment {
            return TaipeiTourListFragment()
        }

        const val ZH_TW = 0
        const val ZH_CN = 1
        const val EN = 2
        const val JA = 3
        const val KO = 4
        const val ES = 5
        const val ID = 6
        const val TH = 7
        const val VI = 8
    }

    private fun setRecyclerView(key: String, page: Int) {

        presenter?.getData(Config.LANGUAGE.getValue(key), page)
        binding.apply {
            rvTaipeiTour.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = taipeiTourAdapter
            }

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TaipeiTourListFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var lang: List<String> = resources.getStringArray(R.array.lang_array).toList()
        // Default Language
        setRecyclerView("ZH_TW", page)
        binding.toolBar.toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit -> {
                    Toast.makeText(context, "OnClick", Toast.LENGTH_SHORT).show()

                    val builder = AlertDialog.Builder(context)
                    Log.i("List", lang.toString())

                    builder.setItems(
                        lang.toTypedArray(),
                        DialogInterface.OnClickListener { dialogInterface, position ->
                            page = 1
                            tempList.clear()
                            binding.nestSV.fullScroll(ScrollView.FOCUS_UP)
                            when (position) {
                                ZH_TW -> {
                                    Log.i("List", Config.LANGUAGE["ZH_TW"].toString())
                                    setRecyclerView("ZH_TW", 1)
                                    language = Config.LANGUAGE["ZH_TW"].toString()
                                }
                                ZH_CN -> {
                                    Log.i("List", lang[1])
                                    setRecyclerView("ZH_CN", 1)
                                    language = Config.LANGUAGE["ZH_CN"].toString()
                                }
                                EN -> {
                                    Log.i("List", lang[2])
                                    setRecyclerView("EN", 1)
                                    language = Config.LANGUAGE["EN"].toString()
                                }
                                JA -> {
                                    Log.i("List", lang[3])
                                    setRecyclerView("JA", 1)
                                    language = Config.LANGUAGE["JA"].toString()
                                }
                                KO -> {
                                    Log.i("List", lang[4])
                                    setRecyclerView("KO", 1)
                                    language = Config.LANGUAGE["KO"].toString()
                                }
                                ES -> {
                                    Log.i("List", lang[5])
                                    setRecyclerView("ES", 1)
                                    language = Config.LANGUAGE["ES"].toString()
                                }
                                ID -> {
                                    Log.i("List", lang[6])
                                    setRecyclerView("ID", 1)
                                    language = Config.LANGUAGE["ID"].toString()
                                }
                                TH -> {
                                    Log.i("List", lang[7])
                                    setRecyclerView("TH", 1)
                                    language = Config.LANGUAGE["TH"].toString()
                                }
                                VI -> {
                                    Log.i("List", lang[8])
                                    setRecyclerView("VI", 1)
                                    language = Config.LANGUAGE["VI"].toString()
                                }
                            }

                        }).show()
                }
            }
            false
        }

        binding.nestSV.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
            override fun onScrollChange(
                v: NestedScrollView,
                scrollX: Int,
                scrollY: Int,
                oldScrollX: Int,
                oldScrollY: Int
            ) {
                if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                    binding.loading.pbBar.visibility = View.VISIBLE
                    Log.e("Lang", language)
                    Log.e("Page", page.toString())
                    presenter?.getData(language, page)
                }
            }

        })


    }


    override fun onItemSelected(item: DataItem) {
        (activity as MainActivity).goToDetail(item)

    }

    val tempList = arrayListOf<DataItem>()
    override fun bindData(response: ArrayList<DataItem>) {
        page++
        Log.e("RsData", response.toString())
        tempList.addAll(response)
        taipeiTourAdapter.submitList(tempList)
    }


}

