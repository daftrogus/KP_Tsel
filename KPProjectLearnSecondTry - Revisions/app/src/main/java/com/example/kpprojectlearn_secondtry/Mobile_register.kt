package com.example.kpprojectlearn_secondtry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kpprojectlearn_secondtry.Common.Common
import com.example.kpprojectlearn_secondtry.Model.APIResponse
import com.example.kpprojectlearn_secondtry.Remote.myAPI
import kotlinx.android.synthetic.main.activity_mobile_register.*
import kotlinx.android.synthetic.main.activity_register.login_here_desc
import retrofit2.Call
import retrofit2.Response

class Mobile_register : AppCompatActivity() {

    internal lateinit var mService:myAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_register)

        mService = Common.api

        login_here_desc.setOnClickListener{
            startActivity(Intent(this@Mobile_register,Mobile_Check::class.java))
        }

        register_phone_submit.setOnClickListener{
            createNewPhone(mobilephone_register.text.toString(),email_register.text.toString())
        }
    }

    private fun createNewPhone(Username_mobile_register:String,phone_register:String){
        mService.registerPhoneUser(Username_mobile_register,phone_register)
            .enqueue(object : retrofit2.Callback<APIResponse> {
                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    Toast.makeText(this@Mobile_register, t!!.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                    if (response!!.body()!!.error) {
                        Toast.makeText(this@Mobile_register, response.body()!!.error_msg, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            this@Mobile_register,
                            "Registrasi Nomor Telepon Sukses !" + response.body()!!.uid,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            })
        }
    }
