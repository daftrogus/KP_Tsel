package com.example.kpprojectlearn_secondtry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.kpprojectlearn_secondtry.Common.Common
import com.example.kpprojectlearn_secondtry.Remote.myAPI
import com.example.kpprojectlearn_secondtry.Remote.RetrofitClient
import kotlinx.android.synthetic.main.activity_login.*

class Splashscreen : AppCompatActivity() {

    internal lateinit var mService:myAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // menyembunyikan title bar pada activity ini
        window.requestFeature(Window.FEATURE_NO_TITLE)
        // membuat activity ini full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splashscreen)

        //splash time 4 detik
        Handler().postDelayed({
            //start main Activity
            startActivity(Intent(this@Splashscreen, Login::class.java))
            //finish main Activity
            finish()
        },4000)
    }
}
