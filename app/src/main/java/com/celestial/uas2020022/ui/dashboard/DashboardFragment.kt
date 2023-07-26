package com.celestial.uas2020022.ui.dashboard
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.celestial.uas2020022.app.ApiConfig
import com.celestial.uas2020022.R
import com.celestial.uas2020022.adapter.AdapterAyam
import com.celestial.uas2020022.model.AyamModel
import com.celestial.uas2020022.model.ResponseAyam

import retrofit2.Call
import retrofit2.Response

class DashboardFragment : Fragment() {

    //
    lateinit var rvAyam: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

        init(view)
        getAyam()
        return view
    }

    private var listAyam: ArrayList<AyamModel> = ArrayList()

    fun getAyam(){
        ApiConfig.instanceRetrofit.getAyam().enqueue(object :
            retrofit2.Callback<ResponseAyam> {

            override fun onResponse(call: Call<ResponseAyam>, response: Response<ResponseAyam>) {
                val res = response.body()!!
                listAyam = res.ayam
                displayAyam()
            }
            override fun onFailure(call: Call<ResponseAyam>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayAyam() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvAyam.adapter = AdapterAyam(requireActivity(), listAyam)
        rvAyam.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvAyam=view.findViewById(R.id.recyler_ayam)
    }

}
