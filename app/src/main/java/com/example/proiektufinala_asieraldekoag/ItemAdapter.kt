package com.example.proiektufinala_asieraldekoag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NombreAdapter(
    private val produktuak: List<Produktu>,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<NombreAdapter.NombreViewHolder>() {

    class NombreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Izena: TextView = itemView.findViewById(R.id.tvIzena)
        val Mota: TextView = itemView.findViewById(R.id.tvMota)
        val Prezioa: TextView = itemView.findViewById(R.id.tvPrezioa)
        val btnBorrar: View = itemView.findViewById(R.id.btnBorrar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return NombreViewHolder(view)
    }

    override fun onBindViewHolder(holder: NombreViewHolder, position: Int) {
        val produktua = produktuak[position]
        holder.Izena.text = "Izena: ${produktua.izena}"
        holder.Mota.text = "Mota: ${produktua.mota}"
        holder.Prezioa.text = "Prezioa: ${produktua.prezioa} €"

        holder.btnBorrar.setOnClickListener {
            onDeleteClick(produktua.id)
        }
    }

    override fun getItemCount(): Int {
        return produktuak.size
    }
}
