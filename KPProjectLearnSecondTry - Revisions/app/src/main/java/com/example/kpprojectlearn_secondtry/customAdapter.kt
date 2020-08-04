package com.example.kpprojectlearn_secondtry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_mobile__check.view.*
import org.json.JSONObject
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter


abstract class customAdapter(private val PhoneUsername: List<JSONObject>) : RecyclerView.Adapter<phoneHolder>(), ListAdapter {
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1 : Int): phoneHolder {
        return phoneHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_mobile__check,viewGroup,false))
    }

    override fun getItemCount(): Int = PhoneUsername.size

    override fun onBindViewHolder(holder: phoneHolder, position: Int) {
        holder.bindPhone(PhoneUsername)
    }
}

class phoneHolder(view: View) : RecyclerView.ViewHolder(view){
    private val numberName = view.answer_data

    fun bindPhone(nama_hp: List<JSONObject>){
        numberName.text = nama_hp.toString()
    }
}

class myPagerAdapter(fm : FragmentManager): FragmentPagerAdapter(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragmentList : MutableList<Fragment> = ArrayList()
    private val titleList : MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment,title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}

