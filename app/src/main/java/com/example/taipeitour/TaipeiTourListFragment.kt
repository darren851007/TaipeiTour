package com.example.taipeitour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeitour.databinding.TaipeiTourListFragmentBinding
import com.example.taipeitour.utils.ActivityUtils
import com.example.taipeitourimport.TaipeiTourListAdapter

class TaipeiTourListFragment : Fragment(), TaipeiTourListContract.View, TaipeiTourListAdapter.CustomListeners{

    private lateinit var binding: TaipeiTourListFragmentBinding
    private val presenter: TaipeiTourListContract.Presenter? by lazy {
        TaipeiTourListPresenter(this)
    }
    companion object {
        fun newInstance(): TaipeiTourListFragment {
            return TaipeiTourListFragment()
        }
    }

    private fun setRecyclerView() {
        val adapter = TaipeiTourListAdapter(this)

        binding.rvTaipeiTour.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
            presenter?.loadData()?.let { adapter.submitList(it) }
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
    }

    override fun onItemSelected(position: Int) {
        Toast.makeText(context, "Position = $position", Toast.LENGTH_SHORT).show()
        (activity as MainActivity).goToDetail()
    }



}