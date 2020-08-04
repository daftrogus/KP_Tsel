package com.example.kpprojectlearn_secondtry

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kpprojectlearn_secondtry.Common.Common
import com.example.kpprojectlearn_secondtry.Model.Absensi
import com.example.kpprojectlearn_secondtry.Model.Score
import com.example.kpprojectlearn_secondtry.Remote.myAPI
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_homepage_app.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.graphics.Color.LTGRAY
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import android.R.id
import android.R.layout
import retrofit2.Retrofit


 // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DashboardFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DashboardFragment : Fragment() {

    lateinit var mLineChart : LineChart
    lateinit var mPieChartJanuari : PieChart
    lateinit var mPieChartFebruari : PieChart
    lateinit var mPieChartMaret : PieChart
    lateinit var mPieChartApril : PieChart
    lateinit var mPieChartMei : PieChart
    var colorClassArray = intArrayOf(Color.BLUE,Color.GREEN,Color.RED)
    lateinit var mService: myAPI

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
//        var mpLineChart: LineChart
//        val mpLineChart:LineChart = LineChart(context)

        mService = Common.api
        val ARG_NAME = wellcome_fullname
        val bulan_januari = "januari"
        val bulan_februari = "februari"
        val bulan_maret = "maret"
        val bulan_april = "april"
        val bulan_mei = "mei"

        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        mLineChart = view.findViewById(R.id.scoreboard)
//        val email = newInstance(ARG_NAME.toString())
        val email = getArguments()!!.getString("Username")
        getScoreSiswa(email.toString())
//       Log.e("SENDAL",email.toString())
        mPieChartJanuari = view.findViewById(R.id.pie_januari)
        getAbsensi(email.toString(),bulan_januari)
//        setUpPieChartData()
//        Log.e("KRUPUK",bulan_januari)
        mPieChartFebruari = view.findViewById(R.id.pie_februari)
        getAbsensi(email.toString(),bulan_februari)
        mPieChartMaret = view.findViewById(R.id.pie_maret)
        getAbsensi(email.toString(),bulan_maret)
        mPieChartApril = view.findViewById(R.id.pie_april)
        getAbsensi(email.toString(),bulan_april)
        mPieChartMei = view.findViewById(R.id.pie_mei)
        getAbsensi(email.toString(),bulan_mei)
//        Log.e("SENDAL",email.toString())
        //add your view before id else getting nullpointer exception
////        val thisLineChart = mLineChart.findViewById<RelativeLayout>(R.id.scoreboard)
//        val LineDataSet1 = LineDataSet(dataValuesKIMIA(), "Matematika")
//        val dataSets : ArrayList<ILineDataSet> = ArrayList()
//        dataSets.add(LineDataSet1)
//
//        val data = LineData(dataSets)
//        mLineChart.data = data
//        mLineChart.invalidate()

        return view
    }

//    fun dataValuesKIMIA(): ArrayList<Entry> {
//        val dataValsKIMIA = ArrayList<Entry>()
//        dataValsKIMIA.add(Entry(1F,60f))
//        dataValsKIMIA.add(Entry(2F,70f))
//        dataValsKIMIA.add(Entry(3F,80f))
//        dataValsKIMIA.add(Entry(4F,90f))
//        dataValsKIMIA.add(Entry(5F,100f))
//        return dataValsKIMIA
//    }

    companion object {
        fun newInstance(Username: String?): DashboardFragment{
            val args = Bundle()
            args.putString("Username",Username)
            val fragsss = DashboardFragment()
            fragsss.arguments = args
            return fragsss
        }
    }

    private fun getScoreSiswa(email : String) {
//        val januari = "Januari"
//        val februari = "Februari"
//        val maret = "Maret"
//        val april = "April"
//        val mei = "Mei"
        mService.getScoreSiswa(email).enqueue(object : retrofit2.Callback<List<Score>> {
            override fun onResponse(call: Call<List<Score>>, response: Response<List<Score>>) {
//                Log.e("ERROR",email)
                if (response.body() != null) {
                    val listEntries: ArrayList<ILineDataSet> = ArrayList()
                    for (score: Score in response.body()!!) {
                        if (score.getMataPelajaran().toString() == "MTK") {
                            fun dataValuesMTK(): ArrayList<Entry> {
                                val dataValsMTK = ArrayList<Entry>()
                                dataValsMTK.add(Entry(1F, score.getNilaiJanuari()!!.toFloat()))
                                dataValsMTK.add(Entry(2F, score.getNilaiFebruari()!!.toFloat()))
                                dataValsMTK.add(Entry(3F, score.getNilaiMaret()!!.toFloat()))
                                dataValsMTK.add(Entry(4F, score.getNilaiApril()!!.toFloat()))
                                dataValsMTK.add(Entry(5F, score.getNilaiMei()!!.toFloat()))

                                return dataValsMTK
                            }

                            val LineDataSet1 = LineDataSet(dataValuesMTK(), "Matematika")
                            LineDataSet1.setColor(Color.RED)
                            listEntries.add(LineDataSet1)

                        } else if (score.getMataPelajaran().toString() == "FISIKA") {
                            fun dataValuesFISIKA(): ArrayList<Entry> {
                                val dataValsFISIKA = ArrayList<Entry>()
                                dataValsFISIKA.add(Entry(1F, score.getNilaiJanuari()!!.toFloat()))
                                dataValsFISIKA.add(Entry(2F, score.getNilaiFebruari()!!.toFloat()))
                                dataValsFISIKA.add(Entry(3F, score.getNilaiMaret()!!.toFloat()))
                                dataValsFISIKA.add(Entry(4F, score.getNilaiApril()!!.toFloat()))
                                dataValsFISIKA.add(Entry(5F, score.getNilaiMei()!!.toFloat()))

                                return dataValsFISIKA
                            }

                            val LineDataSet2 = LineDataSet(dataValuesFISIKA(), "Fisika")
                            LineDataSet2.setColor(Color.BLUE)
                            listEntries.add(LineDataSet2)

                        } else if (score.getMataPelajaran().toString() == "KIMIA") {
                            fun dataValuesKIMIA(): ArrayList<Entry> {
                                val dataValsKIMIA = ArrayList<Entry>()
                                dataValsKIMIA.add(Entry(1F, score.getNilaiJanuari()!!.toFloat()))
                                dataValsKIMIA.add(Entry(2F, score.getNilaiFebruari()!!.toFloat()))
                                dataValsKIMIA.add(Entry(3F, score.getNilaiMaret()!!.toFloat()))
                                dataValsKIMIA.add(Entry(4F, score.getNilaiApril()!!.toFloat()))
                                dataValsKIMIA.add(Entry(5F, score.getNilaiMei()!!.toFloat()))

                                return dataValsKIMIA
                            }

                            val LineDataSet3 = LineDataSet(dataValuesKIMIA(), "Kimia")
                            LineDataSet3.setColor(Color.GREEN)
                            listEntries.add(LineDataSet3)
                        }
                    }
                    val data = LineData(listEntries)
                    mLineChart.data = data
                    mLineChart.animateY(3000)
                    mLineChart.invalidate()
                }
            }

            override fun onFailure(call: Call<List<Score>>, t: Throwable) {

            }
        })

        val ARG_NAME = "Username"

        fun newInstance(Username: String): DashboardFragment {
            val fragment = DashboardFragment()

            val bundle = Bundle().apply {
                putString(ARG_NAME, Username)
            }
            fragment.arguments = bundle

            return fragment
        }
    }

    private fun getAbsensi(email :String,bulan :String){
        Log.e("ERROR_A",bulan)
        mService.getAbsensiSiswa(email,bulan).enqueue(object : retrofit2.Callback<List<Absensi>> {
            override fun onResponse(call: Call<List<Absensi>>, response: Response<List<Absensi>>) {
                Log.e("ERROR_B",email)
                if(response.body() != null) {
                    Log.e("ERROR_C", email)
                    for (absence: Absensi in response.body()!!) {
                        Log.e("ERROR_D", bulan)
                        if (bulan == "januari") {
//                            Log.e("ERROR_E",bulan)
                            val yVals = ArrayList<PieEntry>()
                            if(absence.getJanuariHadir() != "0"){
                                yVals.add(PieEntry(absence.getJanuariHadir()!!.toFloat(), ("Hadir : "+absence.getJanuariHadir()!!.toString())))
                            }
                            if(absence.getJanuariSakit() != "0"){
                                yVals.add(PieEntry(absence.getJanuariSakit()!!.toFloat(), ("Sakit : "+absence.getJanuariSakit()!!.toString())))
                            }
                            if(absence.getJanuariIzin() != "0"){
                                yVals.add(PieEntry(absence.getJanuariIzin()!!.toFloat(), ("Izin : "+absence.getJanuariIzin()!!.toString())))
                            }

                            val dataSet = PieDataSet(yVals, "")
                            dataSet.valueTextSize = 0f
                            val colors = java.util.ArrayList<Int>()
                            colors.add(Color.BLUE)
                            colors.add(Color.RED)
                            colors.add(Color.GREEN)

                            dataSet.setColors(colors)
                            val data = PieData(dataSet)
                            mPieChartJanuari.data = data

                            mPieChartJanuari.isDrawHoleEnabled = false
                            mPieChartJanuari.legend.isEnabled = false
                            mPieChartJanuari.description.isEnabled = true
                            mPieChartJanuari.invalidate()
                        }
                    }
                    for (absence: Absensi in response.body()!!) {
                        if (bulan == "februari") {
//                            Log.e("ERROR_F",bulan)
                            val yVals = ArrayList<PieEntry>()
                            if(absence.getFebruariHadir() != "0"){
                                yVals.add(PieEntry(absence.getFebruariHadir()!!.toFloat(), ("Hadir : "+absence.getFebruariHadir()!!.toString())))
                            }
                            if(absence.getFebruariSakit() != "0"){
                                yVals.add(PieEntry(absence.getFebruariSakit()!!.toFloat(), ("Sakit : "+absence.getFebruariSakit()!!.toString())))
                            }
                            if(absence.getFebruariIzin() != "0"){
                                yVals.add(PieEntry(absence.getFebruariIzin()!!.toFloat(), ("Izin : "+absence.getFebruariIzin()!!.toString())))
                            }

                            val dataSet = PieDataSet(yVals, "")
                            dataSet.valueTextSize = 0f
                            val colors = java.util.ArrayList<Int>()
                            colors.add(Color.BLUE)
                            colors.add(Color.RED)
                            colors.add(Color.GREEN)

                            dataSet.setColors(colors)
                            val data = PieData(dataSet)
                            mPieChartFebruari.data = data

                            mPieChartFebruari.isDrawHoleEnabled = false
                            mPieChartFebruari.legend.isEnabled = false
                            mPieChartFebruari.description.isEnabled = true
                            mPieChartFebruari.invalidate()
                        }
                    }
                    for (absence: Absensi in response.body()!!) {
                        if (bulan == "maret") {

                            val yVals = ArrayList<PieEntry>()
                            if(absence.getMaretHadir() != "0"){
                                yVals.add(PieEntry(absence.getMaretHadir()!!.toFloat(), ("Hadir : "+absence.getMaretHadir()!!.toString())))
                            }
                            if(absence.getMaretSakit() != "0"){
                                yVals.add(PieEntry(absence.getMaretSakit()!!.toFloat(), ("Sakit : "+absence.getMaretSakit()!!.toString())))
                            }
                            if(absence.getMaretIzin() != "0"){
                                yVals.add(PieEntry(absence.getMaretIzin()!!.toFloat(), ("Izin : "+absence.getMaretIzin()!!.toString())))
                            }

                            val dataSet = PieDataSet(yVals, "")
                            dataSet.valueTextSize = 0f
                            val colors = java.util.ArrayList<Int>()
                            colors.add(Color.BLUE)
                            colors.add(Color.RED)
                            colors.add(Color.GREEN)

                            dataSet.setColors(colors)
                            val data = PieData(dataSet)
                            mPieChartMaret.data = data

                            mPieChartMaret.isDrawHoleEnabled = false
                            mPieChartMaret.legend.isEnabled = false
                            mPieChartMaret.description.isEnabled = true
                            mPieChartMaret.invalidate()
                        }
                    }

                    for (absence: Absensi in response.body()!!) {
                        if (bulan == "april") {

                            val yVals = ArrayList<PieEntry>()
                            if(absence.getAprilHadir() != "0"){
                                yVals.add(PieEntry(absence.getAprilHadir()!!.toFloat(), ("Hadir : "+absence.getAprilHadir()!!.toString())))
                            }
                            if(absence.getAprilSakit() != "0"){
                                yVals.add(PieEntry(absence.getAprilSakit()!!.toFloat(), ("Sakit : "+absence.getAprilSakit()!!.toString())))
                            }
                            if(absence.getAprilIzin() != "0"){
                                yVals.add(PieEntry(absence.getAprilIzin()!!.toFloat(), ("Izin : "+absence.getAprilIzin()!!.toString())))
                            }

                            val dataSet = PieDataSet(yVals, "")
                            dataSet.valueTextSize = 0f
                            val colors = java.util.ArrayList<Int>()
                            colors.add(Color.BLUE)
                            colors.add(Color.RED)
                            colors.add(Color.GREEN)

                            dataSet.setColors(colors)
                            val data = PieData(dataSet)
                            mPieChartApril.data = data

                            mPieChartApril.isDrawHoleEnabled = false
                            mPieChartApril.legend.isEnabled = false
                            mPieChartApril.description.isEnabled = true
                            mPieChartApril.invalidate()
                        }
                    }

                    for (absence: Absensi in response.body()!!) {
                        if (bulan == "mei") {

                            val yVals = ArrayList<PieEntry>()
                            if(absence.getMeiHadir() != "0"){
                                yVals.add(PieEntry(absence.getMeiHadir()!!.toFloat(), ("Hadir : "+absence.getMeiHadir()!!.toString())))
                            }
                            if(absence.getMeiSakit() != "0"){
                                yVals.add(PieEntry(absence.getMeiSakit()!!.toFloat(), ("Sakit : "+absence.getMeiSakit()!!.toString())))
                            }
                            if(absence.getMeiIzin() != "0"){
                                yVals.add(PieEntry(absence.getMeiIzin()!!.toFloat(), ("Izin : "+absence.getMeiIzin()!!.toString())))
                            }

                            val dataSet = PieDataSet(yVals, "")
                            dataSet.valueTextSize = 0f
                            val colors = java.util.ArrayList<Int>()
                            colors.add(Color.BLUE)
                            colors.add(Color.RED)
                            colors.add(Color.GREEN)

                            dataSet.setColors(colors)
                            val data = PieData(dataSet)
                            mPieChartMei.data = data

                            mPieChartMei.isDrawHoleEnabled = false
                            mPieChartMei.legend.isEnabled = false
                            mPieChartMei.description.isEnabled = true
                            mPieChartMei.invalidate()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Absensi>>, t: Throwable) {
                Log.e("ERROR_ONFAILURE", t.message)
            }
        })
    }
//    private fun PieTest(){
//        val NoOfEmp =   MutableList<Entry>()
//
//        NoOfEmp.add(Entry(945f, 0f))
//        NoOfEmp.add(Entry(1040f, 1f))
//        NoOfEmp.add(Entry(1133f, 2f))
//        NoOfEmp.add(Entry(1240f, 3f))
//        NoOfEmp.add(Entry(1369f, 4f))
//        NoOfEmp.add(Entry(1487f, 5f))
//        NoOfEmp.add(Entry(1501f, 6f))
//        NoOfEmp.add(Entry(1645f, 7f))
//        NoOfEmp.add(Entry(1578f, 8f))
//        NoOfEmp.add(Entry(1695f, 9f))
//        val dataSet = PieDataSet(NoOfEmp, "Number Of Employees")
//
//        val year = ArrayList()
//
//        year.add("2008")
//        year.add("2009")
//        year.add("2010")
//        year.add("2011")
//        year.add("2012")
//        year.add("2013")
//        year.add("2014")
//        year.add("2015")
//        year.add("2016")
//        year.add("2017")
//        val data = PieData(year, dataSet)
//        pieChart.setData(data)
//        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
//        pieChart.animateXY(5000, 5000)
//    }

//    private fun setUpPieChartData() {
//        val yVals = ArrayList<PieEntry>()
//        yVals.add(PieEntry(30f))
//        yVals.add(PieEntry(2f))
//        yVals.add(PieEntry(4f))
//        yVals.add(PieEntry(22f))
//        yVals.add(PieEntry(12.5f))
//
//        val dataSet = PieDataSet(yVals, "")
//        dataSet.valueTextSize=0f
//        val colors = java.util.ArrayList<Int>()
//        colors.add(Color.GRAY)
//        colors.add(Color.BLUE)
//        colors.add(Color.RED)
//        colors.add(Color.GREEN)
//        colors.add(Color.MAGENTA)
//
//        dataSet.setColors(colors)
//        val data = PieData(dataSet)
//        mPieChart.data = data
//        mPieChart.centerTextRadiusPercent = 0f
//        mPieChart.isDrawHoleEnabled = false
//        mPieChart.legend.isEnabled = false
//        mPieChart.description.isEnabled = false
//    }
}


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        DashboardFragment()
//    }
