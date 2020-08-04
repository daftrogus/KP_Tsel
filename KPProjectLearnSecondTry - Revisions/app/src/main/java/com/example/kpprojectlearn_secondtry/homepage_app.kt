package com.example.kpprojectlearn_secondtry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_homepage_app.*

class homepage_app : AppCompatActivity() {

    lateinit var toolbar: ActionBar
    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navbar_home -> {
                toolbar.title = "TELKOM SCHOOL REPORT"
//                val HomeFragment = HomeFragment.newInstance()
                openFragmentHome(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navbar_dashboard -> {
                toolbar.title = "TELKOM SCHOOL REPORT"
//                val DashboardFragment = DashboardFragment.newInstance()
                openFragmentDashboard(DashboardFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navbar_settings -> {
                toolbar.title = "TELKOM SCHOOL REPORT"
//                val SettingsFragment = SettingsFragment.newInstance()
                openFragmentSettings(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }




//    var textVariable = intent.getStringExtra("Username")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_app)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            val window = window
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//            )
//        }

        toolbar = supportActionBar!!
//        val bottomNavigation : BottomNavigationView = findViewById(R.id.nav_main)
        openFragmentHome(HomeFragment())
        nav_main.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val Username = intent.getStringExtra("Username")
        wellcome_fullname.setText(Username)
        val name = Username
//        val myUsername : String = wellcome_fullname.toString()
//        bundle.putString("Username",myUsername)
//        val fragInfo = DashboardFragment()
//        fragInfo.arguments(bundle)

//        Log.e("TAGGGGGGGGGGGG",Username.toString())
//        val fragment = HomeFragment.newInstance(Username.toString())



//        val viewPager = findViewById<ViewPager>(R.id.viewpager_main)
//        if (viewPager != null){
//            val adapter = myPagerAdapter(supportFragmentManager)
//            adapter.addFragment(HomeFragment(),"HomeFragment")
//            adapter.addFragment(DashboardFragment(),"DashboardFragment")
//            adapter.addFragment(SettingsFragment(),"SettingsFragment")
//            viewPager.adapter = adapter
//            nav_main.
//        }
//
//        nav_main.setOnNavigationItemSelectedListener(viewPager)
    }

    private fun openFragmentHome(fragment: HomeFragment) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun openFragmentDashboard(fragment: DashboardFragment) {
        val Username = intent.getStringExtra("Username")
        Log.e("CLICKED FRAGMENT",Username.toString())
        val bundle = Bundle()
        bundle.putString("Username", Username)
        fragment.setArguments(bundle)
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    private fun openFragmentSettings(fragment: SettingsFragment) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}


