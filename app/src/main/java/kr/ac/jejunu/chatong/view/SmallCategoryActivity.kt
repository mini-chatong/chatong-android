package kr.ac.jejunu.chatong.view

import android.annotation.TargetApi
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout

import kr.ac.jejunu.chatong.R
import kr.ac.jejunu.chatong.adapter.MyAdapter
import kr.ac.jejunu.chatong.fragment.FragmentSupport

class SmallCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_small_category)

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager
        val myAdapter = MyAdapter(supportFragmentManager)
        myAdapter.addFragment(FragmentSupport(), "first")
        myAdapter.addFragment(FragmentSupport(), "second")
        myAdapter.addFragment(FragmentSupport(), "third")
        myAdapter.addFragment(FragmentSupport(), "fourth")
        myAdapter.addFragment(FragmentSupport(), "fifth")
        myAdapter.addFragment(FragmentSupport(), "sixth")
        viewPager.adapter = myAdapter

        val tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }
}
