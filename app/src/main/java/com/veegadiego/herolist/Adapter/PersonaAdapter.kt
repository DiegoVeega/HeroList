package com.veegadiego.herolist.Adapter

import android.app.Person
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.veegadiego.herolist.Models.Persona
import com.veegadiego.herolist.R
import kotlinx.android.synthetic.main.rv_template.view.*

class PersonaAdapter(items:ArrayList<Persona>): RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    var items:ArrayList<Persona>? = null
    var viewHolder:ViewHolder? = null

    init{
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.rv_template, parent,false)
        viewHolder = ViewHolder(vista)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.nombre?.text = item?.nombre
        holder.foto?.setImageResource(item?.foto!!)
    }

    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        var vista = vista

        var foto:ImageView? = null
        var nombre:TextView? = null

        init{
            foto = vista.iv_foto
            nombre = vista.tv_nombre
        }
    }
}