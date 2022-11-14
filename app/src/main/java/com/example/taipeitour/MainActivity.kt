package com.example.taipeitour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.taipeitour.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaipeiTourListContract.View {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToTaipeiTourList()


    }

    private fun goToTaipeiTourList() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TaipeiTourListFragment.newInstance() as Fragment).commit()
    }
}