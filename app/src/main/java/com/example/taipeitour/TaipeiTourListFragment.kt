package com.example.taipeitour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeitour.databinding.TaipeiTourListFragmentBinding
import com.example.taipeitour.model.DataItem
import com.example.taipeitour.model.TaipeiTourModel
import com.example.taipeitourimport.TaipeiTourListAdapter

class TaipeiTourListFragment : Fragment(), TaipeiTourListContract.View, TaipeiTourListAdapter.CustomListeners{

    private lateinit var binding: TaipeiTourListFragmentBinding
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
    }

    private fun setRecyclerView() {
        presenter?.getData()
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
        setRecyclerView()
        binding.toolBar.toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit -> {
                    Toast.makeText(context, "OnClick", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }

    private fun initView() {

    }

    override fun onItemSelected(item: DataItem) {
//        Toast.makeText(context, "Position = $position", Toast.LENGTH_SHORT).show()
        (activity as MainActivity).goToDetail(item)
    }


    override fun bindData(response: List<DataItem>) {
        taipeiTourAdapter.submitList(response)
    }


}

