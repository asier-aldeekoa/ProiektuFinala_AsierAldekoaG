package com.example.proiektufinala_asieraldekoag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NombreAdapter(private val produktuak: List<Produktu>) :
    RecyclerView.Adapter<NombreAdapter.NombreViewHolder>() {

    class NombreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvId)
        val tvIzena: TextView = itemView.findViewById(R.id.tvIzena)
        val tvMota: TextView = itemView.findViewById(R.id.tvMota)
        val tvPrezioa: TextView = itemView.findViewById(R.id.tvPrezioa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return NombreViewHolder(view)
    }

    override fun onBindViewHolder(holder: NombreViewHolder, position: Int) {
        val produktua = produktuak[position]
        holder.tvIzena.text = "Izena: ${produktua.izena}"
        holder.tvMota.text = "Mota: ${produktua.mota}"
        holder.tvPrezioa.text = "Prezioa: ${produktua.prezioa} €"
    }

    override fun getItemCount(): Int {
        return produktuak.size
    }
}