package com.example.equipodefutbol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewNombre: TextView = view.findViewById(R.id.textViewClub)
        private val textViewCampeonatos: TextView = view.findViewById(R.id.textViewTotalCampeonato)
        private val imagenClub: ImageView = view.findViewById(R.id.imageViewEscudo)

        fun bind(equipo: Equipo) {
            textViewNombre.text = "Nombre: " + equipo.name
            textViewCampeonatos.text = "Campeonato: " + equipo.campeonatos

            Glide.with(context)
                .load(equipo.url)
                .into(imagenClub)

            view.setOnClickListener {
                onItemClickListener(equipo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val equipo = getItem(position)
        holder.bind(equipo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}