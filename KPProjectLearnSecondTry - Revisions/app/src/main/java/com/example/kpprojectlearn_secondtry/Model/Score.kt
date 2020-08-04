package com.example.kpprojectlearn_secondtry.Model

import com.google.gson.annotations.SerializedName

public class Score {

    @SerializedName("email")
    private val email: String? = null

    @SerializedName("mata_pelajaran")
    private val mata_pelajaran: String? = null

    @SerializedName("nilai_januari")
    private val nilai_januari: String? = null

    @SerializedName("nilai_februari")
    private val nilai_februari: String? = null

    @SerializedName("nilai_maret")
    private val nilai_maret: String? = null

    @SerializedName("nilai_april")
    private val nilai_april: String? = null

    @SerializedName("nilai_mei")
    private val nilai_mei: String? = null

    fun getEmail(): String? {
        return email
    }

    fun getMataPelajaran(): String? {
        return mata_pelajaran
    }

    fun getNilaiJanuari(): String? {
        return nilai_januari
    }

    fun getNilaiFebruari(): String? {
        return nilai_februari
    }

    fun getNilaiMaret(): String? {
        return nilai_maret
    }

    fun getNilaiApril(): String? {
        return nilai_april
    }

    fun getNilaiMei(): String? {
        return nilai_mei
    }
}