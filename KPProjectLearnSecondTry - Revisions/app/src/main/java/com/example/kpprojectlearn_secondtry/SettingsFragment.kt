package com.example.kpprojectlearn_secondtry


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        //add your view before id else getting nullpointer exception
        return view
    }
    companion object {
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        SettingsFragment()
//    }

}
