package com.example.taipeitour

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taipeitour.databinding.TaipeiTourListFragmentBinding

class TaipeiTourListFragment : Fragment(){

    private lateinit var binding: TaipeiTourListFragmentBinding
    companion object {
        fun newInstance(): TaipeiTourListFragment {
            return TaipeiTourListFragment()
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
    }

}