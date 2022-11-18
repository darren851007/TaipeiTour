package com.example.taipeitour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taipeitour.databinding.ActivityMainBinding
import com.example.taipeitour.model.DataItem
import com.example.taipeitour.utils.ActivityUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToTaipeiTourList()
    }

    private fun goToTaipeiTourList() {
        ActivityUtils.addFragmentToActivity(supportFragmentManager, TaipeiTourListFragment.newInstance(), R.id.fragment_container, false)
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TaipeiTourListFragment.newInstance() as Fragment).commit()
    }

     fun goToDetail(item: DataItem) {
        ActivityUtils.addFragmentToActivity(supportFragmentManager, TaipeiTourDetailFragment.newInstance(item), R.id.fragment_container, true)
    }
}