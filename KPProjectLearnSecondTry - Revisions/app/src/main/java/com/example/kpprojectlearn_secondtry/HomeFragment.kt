package com.example.kpprojectlearn_secondtry


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kpprojectlearn_secondtry.Model.User
import kotlinx.android.synthetic.main.fragment_home.*
import okio.JvmStatic


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    lateinit var ACTIVITY : homepage_app

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{


        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val Username = arguments?.getString(ARG_NAME)

//        val profileName = activity!!.intent.getStringExtra(Username)

           //add your view before id else getting nullpointer exception
      return view
    }
//        inflater.inflate(R.layout.fragment_home, container, false)


    companion object {

        const val ARG_NAME = "Username"

        @JvmStatic
        fun newInstance(Username : String): HomeFragment{
            val fragment = HomeFragment()

            val bundle = Bundle().apply{
                putString(ARG_NAME,Username)
            }
            fragment.arguments = bundle

            return fragment
        }
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        ACTIVITY = context as homepage_app
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        HomeFragment()
//    }

//    val profileName = activity!!.intent.getStringExtra("Username")

}
