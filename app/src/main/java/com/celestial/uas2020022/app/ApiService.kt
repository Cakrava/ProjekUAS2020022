package com.celestial.uas2020022.app


import com.celestial.uas2020022.model.ResponseAyam
import com.celestial.uas2020022.model.KopiModel
import com.celestial.uas2020022.model.ResponseKopi
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("tblBunga/save")
    fun saveBunga(
        @Body data: KopiModel
    ): Call<ResponseKopi>

    @GET("ayam")
    fun getAyam(): Call<ResponseAyam>
    @GET("kopi")
    fun getKopi(): Call<ResponseKopi>
}
