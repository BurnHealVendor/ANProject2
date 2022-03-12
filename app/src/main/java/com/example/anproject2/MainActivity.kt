package com.example.anproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anproject2.views.FirstFrag

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentNavigation(supportFragmentManager, FirstFrag.newInstance())
    }
}