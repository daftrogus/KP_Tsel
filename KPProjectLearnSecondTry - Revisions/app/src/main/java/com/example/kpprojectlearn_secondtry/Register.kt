package com.example.kpprojectlearn_secondtry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kpprojectlearn_secondtry.Common.Common
import com.example.kpprojectlearn_secondtry.Model.APIResponse
import com.example.kpprojectlearn_secondtry.Remote.myAPI
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {

    internal lateinit var mService:myAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //inisialisasi service
        mService = Common.api

        register_submit.setOnClickListener{
            createNewUser(email_register.text.toString(),username_register.text.toString(),fullname_register.text.toString()
                ,mobilephone_register.text.toString(),password_register.text.toString())
        }

        login_here_desc.setOnClickListener{
            startActivity(Intent(this@Register,Login::class.java))
        }

    }

    private fun createNewUser(email_register:String,username_register:String,fullname_register:String,mobilephone_register:String,password_register:String) {
        mService.registerUser(email_register, username_register, fullname_register, mobilephone_register, password_register)
            .enqueue(object : Callback<APIResponse> {
                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    Toast.makeText(this@Register, t!!.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                    if (response!!.body()!!.error) {
                        Toast.makeText(this@Register, response.body()!!.error_msg, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@Register, "Registrasi sukses !" + response.body()!!.uid, Toast.LENGTH_SHORT)
                            .show()
                        startActivity(Intent(this@Register,Login::class.java))
                    }
                }

            })
        }
    }
