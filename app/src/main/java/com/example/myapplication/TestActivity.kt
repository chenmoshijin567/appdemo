package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.example.myapplication.databinding.ActivityTestBinding
import com.example.myapplication.ui.main.SectionsPagerAdapter

class TestActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter=SectionsPagerAdapter(this, supportFragmentManager)//适配器 加载视图
        val viewPager: ViewPager=binding.viewPager
        viewPager.adapter=sectionsPagerAdapter
        val tabs: TabLayout=binding.tabs
        tabs.setupWithViewPager(viewPager)
    }
    override fun onClick(v: View?) {
        Toast.makeText(this,"加载事物到视图",Toast.LENGTH_SHORT).show()
    }
    }


