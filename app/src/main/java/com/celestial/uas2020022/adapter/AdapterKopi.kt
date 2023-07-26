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
import com.celestial.uas2020022.model.KopiModel
import kotlin.collections.ArrayList

class AdapterKopi(var activity: Activity, var data: ArrayList<KopiModel>): RecyclerView.Adapter<AdapterKopi.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val kdkopi = view.findViewById<TextView>(R.id.kdkopi)
        val nama_kopi = view.findViewById<TextView>(R.id.nama_kopi)
        val jenis = view.findViewById<TextView>(R.id.jenis)
        val harga = view.findViewById<TextView>(R.id.harga)
        val foto = view.findViewById<ImageView>(R.id.foto)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.kopi, parent, false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.kdkopi.text = a.kdkopi
        holder.nama_kopi.text = a.nama_kopi
        holder.jenis.text = a.jenis
        holder.harga.text = a.harga.toString()


        // Menampilkan gambar menggunakan Glide
        Glide.with(context)
            .load("http://10.234.232.145/laravel_1/storage/app/public/${a.foto}")
            .into(holder.foto)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
