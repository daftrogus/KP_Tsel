package com.example.kpprojectlearn_secondtry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.example.kpprojectlearn_secondtry.Common.Common
import com.example.kpprojectlearn_secondtry.Model.APIResponse
import com.example.kpprojectlearn_secondtry.Remote.myAPI
import kotlinx.android.synthetic.main.activity_mobile__check.*
import retrofit2.Call
import retrofit2.Response


class   Mobile_Check : AppCompatActivity() {

    internal lateinit var mService: myAPI
    lateinit var listView_details :ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile__check)
//        listView_details = findViewById<ListView>(R.id.recyclerView) as ListView
        mService = Common.api

        login_here_check_desc.setOnClickListener {
            startActivity(Intent(this@Mobile_Check, Login::class.java))
        }

        phone_check_submit.setOnClickListener {

//            val retrofit = Retrofit.Builder()
//                .baseUrl("http://192.168.0.106/webservicePHP/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()


//            val gulugulu = mService.showPhoneUser(phonenumber_check.toString())
//            val answers = findViewById<TextView>(R.id.phonenumber_check)
//            val answerss = findViewById<TextView>(R.id.phonecheck_answer_title)
//            Log.e("error", gulugulu.toString())
            phonecheck_answer_box.setVisibility(View.VISIBLE)
//            phonecheck_answer_title.setVisibility(View.VISIBLE)
//            phonecheck_answer_title.setText(gulugulu.toString())
//            Log.e("TAI",gulugulu.toString())
//            answerss.visibility = View.VISIBLE
            showPhoneData(email_register.text.toString())

////            val data_changed = showPhoneData(answers.text.toString())
////            answer_data.text = data_changed.toString()

        }
    }

//    private fun saveNamatoPreferences(nama_hp : List<com.example.kpprojectlearn_secondtry.Model.phoneUser>){
//        val prefEditor = PreferenceManager.getDefaultSharedPreferences(this@Mobile_Check).edit()
//        val jsonString = Gson().toJson(nama_hp)
//        prefEditor.putString("nama_hp",jsonString).apply()
//    }

    private fun showPhoneData(phonenumber_check: String){
        mService.showPhoneUser(phonenumber_check).
            enqueue(object : retrofit2.Callback<APIResponse>{
            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                phonecheck_answer_box.setVisibility(View.INVISIBLE)
                phonecheck_answer_no.setVisibility(View.VISIBLE)
            }

            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                if (response!!.body()!!.fullname!!.equals("")) {
                    Toast.makeText(this@Mobile_Check, "ERROR"+response.body()!!.error_msg, Toast.LENGTH_SHORT).show()
                } else {
                    phonecheck_answer_box.setVisibility(View.VISIBLE)
                    answer_data.setText(response.body()!!.fullname.toString())
                }
            }
        })

//                override fun onFailure(call: Call<com.example.kpprojectlearn_secondtry.Model.phoneUser>, t: Throwable) {
//                    Toast.makeText(this@Mobile_Check, t!!.message, Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onResponse(
//                    call: Call<com.example.kpprojectlearn_secondtry.Model.phoneUser>,
//                    response: Response<com.example.kpprojectlearn_secondtry.Model.phoneUser>
//                ) {
//                    phonecheck_answer_box.setVisibility(View.VISIBLE)
//                    var stringresponse = response.body()!!.toString()
//                    val json_phone: JSONObject = JSONObject(stringresponse)
//                    var jsonaobject_info: JSONObject = json_phone.getJSONObject("nama_hp")
//                    var model:com.example.kpprojectlearn_secondtry.Model.phoneUser = com.example.kpprojectlearn_secondtry.Model.phoneUser()
//                    val listJSON = listOf(jsonaobject_info)
//
//                    runOnUiThread{
//                        val obj_adapter : customAdapter
//                        obj_adapter = customAdapter(listJSON)
//                        listView_details.adapter = obj_adapter
//                    }
//                    ===============================================================================
//                    val gson = GsonBuilder().setLenient().create()
//                    val specificURL = gson.fromJson("no_hp", myAPI::class.java)
//                    val converted = specificURL.toString()
//                    Log.e("X", converted)
//                    answer_data.setText(converted)
//                    if(answer_data != null) {
//                    } else {
//                        phonecheck_answer_no.setVisibility(View.VISIBLE)
//                    }
//                }
    }
}



//                    val jeson = GsonBuilder().setLenient().create()
//                    phonecheck_answer_box.setVisibility(View.VISIBLE)
//                    val jehson = jeson.fromJson(FileReader(response<APIResponse>)
//                    val waduh = jehson.toString()
//                    var taikuda: StringReader = StringReader(waduh)
//                    answer_data.setText(taikuda.toString())
//                    Log.e("BIJI",taikuda.toString())


// val postsApi = retrofit.create(myAPI::class.java)
//
// val clientOK = OkHttpClient()
// .newBuilder().addInterceptor(LastFmRequestInterceptor(phonenumber_check,3600))
// .addInterceptor(HttpLoggingInterceptor().apply {
// level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
// }).build()
//
// val retrofit = Retrofit.Builder()
// .baseUrl("http://192.168.0.106/webservicePHP/")
// .client(clientOK)
// .addConverterFactory(GsonConverterFactory.create())
// .build()
//
// val okHTTPok = okhttp3
// .Request.Builder()
// .url("http://92.168.0.106/webservicePHP/")
// .get().build()
//
// val lastFmService = retrofit.create(myAPI::class.java)
//
// val callcall = lastFmService.showPhoneUser(phonenumber_check)
// answer_data.setText(callcall.toString())
//
// clientOK.newCall(okHTTPok).enqueue(object : okhttp3.Callback {
// override fun onFailure(call: okhttp3.Call, e: IOException) {
// //Toast.makeText(this@Mobile_Check, t!!.message, Toast.LENGTH_SHORT).show()
// println("gagal melakukan permintaan data")
// }
//
// override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
// //                val gson = GsonBuilder().create()
// //                val body = response.body().toString()
// //                val jehson = gson.fromJson(body, myAPI::class.java)
// //                Log.e("X", jehson.toString())
//
// }
// })
// }
// }            //override fun onFailure(call: Call<phoneUser>, t: Throwable) {
// //    Toast.makeText(this@Mobile_Check, t!!.message, Toast.LENGTH_SHORT).show()
//x
// //override fun onResponse(call: Call<phoneUser>, response: Response<phoneUser>) {
// //    val body = response.raw().body()?.string()
// //    Log.e("X", body)
//
// /*
// mService.showPhoneUser(phonenumber_check)
// .enqueue(object : Callback<APIResponse> {
// override fun onFailure(call: Call<APIResponse>, t: Throwable) {
// Toast.makeText(this@Mobile_Check, t!!.message, Toast.LENGTH_SHORT).show()
// }
//
// override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
// Log.e("val", response.body().toString()) */
// //                    if (phonenumber_check != null) {
// //                        val answers = findViewById<TextView>(R.id.phonenumber_check)
// //                        answer_data.text = response.message()
// //Log.w("tes", response.body().toString())
// //var answer_data = response.body().toString()
// // variable penampung JSON dimana? Variable yang buat text view dimana?
// //                        answer_data.setText(response.raw().toString())
// //                    }else{
// //                        phonecheck_answer_no.setVisibility(View.VISIBLE)
// //                    }
// //                    }
// //}
// //})