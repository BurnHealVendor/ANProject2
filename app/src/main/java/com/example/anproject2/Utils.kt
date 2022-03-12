package com.example.anproject2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.anproject2.views.FirstFrag

fun fragmentNavigation(supportFragmentManager: FragmentManager, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.mainFragContainer, fragment)
        .addToBackStack(fragment.id.toString())
        .commit()
}