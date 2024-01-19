package com.example.homework_7m.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_7m.databinding.ActivityMainBinding
import com.example.homework_7m.presentation.screens.cameras.CamerasFragment
import com.example.homework_7m.presentation.screens.doors.DoorsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragmentList = listOf(
        CamerasFragment(),
        DoorsFragment()
    )
    private val fragmentListTitles = listOf(
        "Камеры",
        "Двери"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        val adapter = PagerAdapter(this@MainActivity, fragmentList)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, pos -> tab.text = fragmentListTitles[pos]
        }.attach()
    }

}