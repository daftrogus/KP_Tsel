package com.example.kpprojectlearn_secondtry

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import com.example.kpprojectlearn_secondtry.Common.Common
import com.example.kpprojectlearn_secondtry.Model.APIResponse
import kotlinx.android.synthetic.main.activity_login.*
import com.example.kpprojectlearn_secondtry.Remote.myAPI
import kotlinx.android.synthetic.main.activity_homepage_app.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    internal lateinit var mService:myAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_guru.setOnClickListener{
            authenticateUser(Email.text.toString(),password_login.text.toString())
        }

        login_here.setOnClickListener {
            startActivity(Intent(this@Login, Register::class.java))
        }

        phone_check_button.setOnClickListener {
            startActivity(Intent(this@Login,Mobile_Check::class.java))
        }

        //inisialisasi service
        mService = Common.api
    }



    private fun authenticateUser(Email: String,Password_email:String){
        mService.loginUser(Email,Password_email)
            .enqueue(object: Callback<APIResponse>{
                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    Toast.makeText(this@Login,t!!.message,Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                    if(response.body()!!.error){
                        Toast.makeText(this@Login,"Terjadi Sebuah Error : "+response.body()!!.error_msg, Toast.LENGTH_SHORT).show()
                        //Log.e("X",mService.loginUser(mail,password_email).toString())
                    }else{
                        Toast.makeText(this@Login,"Anda Berhasil Login",Toast.LENGTH_SHORT).show()
                        val username_value = Email
                        val intent = Intent(this@Login,homepage_app::class.java)
                        intent.putExtra("Username",username_value)
                        startActivity(intent)
                    }
                }

            })
    }
}
