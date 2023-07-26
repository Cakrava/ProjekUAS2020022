package com.celestial.uas2020022.ui.home
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
import com.celestial.uas2020022.adapter.AdapterKopi
import com.celestial.uas2020022.model.KopiModel
import com.celestial.uas2020022.model.ResponseKopi
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    //
    lateinit var rvKopi: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getKopi()
        return view
    }

    private var listKopi: ArrayList<KopiModel> = ArrayList()

    fun getKopi(){
        ApiConfig.instanceRetrofit.getKopi().enqueue(object :
            retrofit2.Callback<ResponseKopi> {

            override fun onResponse(call: Call<ResponseKopi>, response: Response<ResponseKopi>) {
                val res = response.body()!!
                listKopi = res.kopi
                displayKopi()
            }
            override fun onFailure(call: Call<ResponseKopi>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayKopi() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvKopi.adapter = AdapterKopi(requireActivity(), listKopi)
        rvKopi.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvKopi=view.findViewById(R.id.recyler_view)
    }

}
