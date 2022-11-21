package com.example.taipeitour

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeitour.databinding.TaipeiTourListFragmentBinding
import com.example.taipeitour.model.DataItem
import com.example.taipeitour.network.Config
import com.example.taipeitourimport.TaipeiTourListAdapter
import kotlinx.coroutines.NonDisposableHandle.parent

class TaipeiTourListFragment : Fragment(), TaipeiTourListContract.View, TaipeiTourListAdapter.CustomListeners{

    private lateinit var binding: TaipeiTourListFragmentBinding
    private var page = 1
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
        const val JP = 3
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
        // Default Language
        setRecyclerView("ZH_TW",page)
        binding.toolBar.toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit -> {
                    Toast.makeText(context, "OnClick", Toast.LENGTH_SHORT).show()
                    var lang: List<String> = resources.getStringArray(R.array.lang_array).toList()
                    val builder = AlertDialog.Builder(context)
                    Log.i("List", lang.toString())

                    builder.setItems(lang.toTypedArray(), DialogInterface.OnClickListener { dialogInterface, position ->
                        when (position) {
                            ZH_TW -> {
                                Log.i("List", Config.LANGUAGE["ZH_TW"].toString())
                                setRecyclerView("ZH_TW",1)
                            }
                            ZH_CN -> {
                                Log.i("List", lang[1])
                                setRecyclerView("ZH_CN",1)
                            }
                            EN -> {
                                Log.i("List", lang[2])
                                setRecyclerView("EN",1)
                            }
                            JP -> {
                                Log.i("List", lang[3])
                                setRecyclerView("JP",1)
                            }
                            KO -> {
                                Log.i("List", lang[4])
                                setRecyclerView("KO",1)
                            }
                            ES -> {
                                Log.i("List", lang[5])
                                setRecyclerView("ES",1)
                            }
                            ID -> {
                                Log.i("List", lang[6])
                                setRecyclerView("ID",1)
                            }
                            TH -> {
                                Log.i("List", lang[7])
                                setRecyclerView("TH",1)
                            }
                            VI -> {
                                Log.i("List", lang[8])
                                setRecyclerView("VI",1)
                            }
                        }

                    }) .show()
                }
            }
            false
        }
    }

    private fun initView() {

    }

    override fun onItemSelected(item: DataItem) {
        (activity as MainActivity).goToDetail(item)

    }


    override fun bindData(response: List<DataItem>) {
        taipeiTourAdapter.submitList(response)
    }


}

