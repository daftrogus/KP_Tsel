package com.example.kpprojectlearn_secondtry.Remote

import android.database.Observable
import com.example.kpprojectlearn_secondtry.Model.APIResponse
import com.example.kpprojectlearn_secondtry.Model.Absensi
import com.example.kpprojectlearn_secondtry.Model.phoneUser
import retrofit2.Call
import retrofit2.http.*
import com.example.kpprojectlearn_secondtry.Model.Score



interface myAPI{
    @FormUrlEncoded
    @POST("registerAPI.php")
    fun registerUser(@Field("email")email:String,@Field("username")username:String,
                     @Field("fullname")fullname:String,@Field("mobilephone") mobilephone:String,
                     @Field("password") password: String):Call<APIResponse>

    @FormUrlEncoded
    @POST("login.php")
    fun loginUser(@Field("email")email:String,@Field("password") password:String):Call<APIResponse>

    @FormUrlEncoded
    @POST("register_phone.php")
    fun registerPhoneUser(@Field("no_hp")no_hp:String,@Field("nama_hp") nama_hp:String) :Call<APIResponse>

    @FormUrlEncoded
    @POST("search_phone.php")
    fun showPhoneUser(@Field("mobilephone")phonenumber_check:String) :Call<APIResponse>

    @FormUrlEncoded
    @POST("search_nilai.php")
    fun getScoreSiswa(@Field("email")email: String): Call<List<Score>>

    @FormUrlEncoded
    @POST("search_absensi.php")
    fun getAbsensiSiswa(@Field("email")email:String,@Field("bulan")bulan: String) : Call<List<Absensi>>
}

