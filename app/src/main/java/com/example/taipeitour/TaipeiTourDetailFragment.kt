package com.example.taipeitour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taipeitour.databinding.TaipeiTourListDetailFragmentBinding

class TaipeiTourDetailFragment: Fragment(), TaipeiTourDetailContract.View {
    private lateinit var binding: TaipeiTourListDetailFragmentBinding
    private val presenter: TaipeiTourDetailContract.Presenter by lazy {
        TaipeiTourDetailPresenter(this)
    }
    companion object {
        fun newInstance(): TaipeiTourDetailFragment {
            return TaipeiTourDetailFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TaipeiTourListDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

}