package com.example.kpprojectlearn_secondtry.Model

import com.google.gson.annotations.SerializedName

public class Absensi {

    @SerializedName("email")
    private val email: String? = null

    @SerializedName("bulan")
    private val bulan : String? = null

    //januari
    @SerializedName("januari_hadir")
    private val januari_hadir: String? = null

    @SerializedName("januari_sakit")
    private val januari_sakit: String? = null

    @SerializedName("januari_izin")
    private val januari_izin: String? = null

    //februari
    @SerializedName("februari_hadir")
    private val februari_hadir: String? = null

    @SerializedName("februari_sakit")
    private val februari_sakit: String? = null

    @SerializedName("februari_izin")
    private val februari_izin: String? = null

    //maret
    @SerializedName("maret_hadir")
    private val maret_hadir: String? = null

    @SerializedName("maret_sakit")
    private val maret_sakit: String? = null

    @SerializedName("maret_izin")
    private val maret_izin: String? = null

    //april
    @SerializedName("april_hadir")
    private val april_hadir: String? = null

    @SerializedName("april_sakit")
    private val april_sakit: String? = null

    @SerializedName("april_izin")
    private val april_izin: String? = null

    //mei
    @SerializedName("mei_hadir")
    private val mei_hadir: String? = null

    @SerializedName("mei_sakit")
    private val mei_sakit: String? = null

    @SerializedName("mei_izin")
    private val mei_izin: String? = null

    fun getEmail(): String? {
        return email
    }

    fun getBulan(): String? {
        return bulan
    }

    fun getJanuariHadir(): String? {
        return januari_hadir
    }

    fun getJanuariSakit(): String? {
        return januari_sakit
    }

    fun getJanuariIzin(): String? {
        return januari_izin
    }

    fun getFebruariHadir(): String? {
        return februari_hadir
    }

    fun getFebruariSakit(): String? {
        return februari_sakit
    }

    fun getFebruariIzin(): String? {
        return februari_izin
    }

    fun getMaretHadir(): String? {
        return maret_hadir
    }

    fun getMaretSakit(): String? {
        return maret_sakit
    }

    fun getMaretIzin(): String? {
        return maret_izin
    }

    fun getAprilHadir(): String? {
        return april_hadir
    }

    fun getAprilSakit(): String? {
        return april_sakit
    }

    fun getAprilIzin(): String? {
        return april_izin
    }

    fun getMeiHadir(): String? {
        return mei_hadir
    }

    fun getMeiSakit(): String? {
        return mei_sakit
    }

    fun getMeiIzin(): String? {
        return mei_izin
    }
}


