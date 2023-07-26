package com.celestial.uas2020022.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.celestial.uas2020022.R
import com.celestial.uas2020022.model.AyamModel
import kotlin.collections.ArrayList

class AdapterAyam(var activity: Activity, var data: ArrayList<AyamModel>): RecyclerView.Adapter<AdapterAyam.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val kdayam = view.findViewById<TextView>(R.id.kdayam)
        val berat = view.findViewById<TextView>(R.id.berat)
        val jenis = view.findViewById<TextView>(R.id.jenis)
        val harga = view.findViewById<TextView>(R.id.harga)
        val foto = view.findViewById<ImageView>(R.id.foto)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ayam, parent, false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.kdayam.text = a.kdayam
        holder.berat.text = a.berat
        holder.jenis.text = a.jenis
        holder.harga.text = a.harga.toString()


        // Menampilkan gambar menggunakan Glide
        Glide.with(context)
            .load("http://10.234.201.90/laravel_1/storage/app/public/${a.foto}")
            .into(holder.foto)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
