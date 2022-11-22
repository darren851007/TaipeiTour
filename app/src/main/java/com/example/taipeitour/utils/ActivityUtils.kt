package com.example.taipeitour.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ActivityUtils {
    companion object {
        fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, containerId: Int) {
            fragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commit()
        }


        fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment, containerId: Int, hideCurrent: Boolean) {
            val transAction: FragmentTransaction = fragmentManager.beginTransaction()
            if (hideCurrent) {
                hideCurrentFragment(fragmentManager, containerId, transAction)
            }
                transAction.add(containerId, fragment)
                transAction.addToBackStack(null)
            transAction.commit()
        }

        fun hideCurrentFragment(fragmentManager: FragmentManager, containerId: Int, transaction: FragmentTransaction) {
            val curFragment = fragmentManager.findFragmentById(containerId)
            if (curFragment != null) {
                transaction.hide(curFragment)
            }
        }


    }

}