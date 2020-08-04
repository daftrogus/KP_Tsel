package com.example.kpprojectlearn_secondtry.Common

import com.example.kpprojectlearn_secondtry.Remote.RetrofitClient
import com.example.kpprojectlearn_secondtry.Remote.myAPI

object Common {
    val BASE_URL="http://172.22.60.28/webservicePHP/"


    val api: myAPI
    get() = RetrofitClient.getClient(BASE_URL).create(myAPI::class.java)
}