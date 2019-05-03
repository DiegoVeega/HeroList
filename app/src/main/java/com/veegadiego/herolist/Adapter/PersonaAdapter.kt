package com.veegadiego.herolist.Adapter

import android.app.Person
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.veegadiego.herolist.Interface.ClickListener
import com.veegadiego.herolist.Models.Persona
import com.veegadiego.herolist.R
import kotlinx.android.synthetic.main.rv_template.view.*

class PersonaAdapter(items:ArrayList<Persona>, var clickListener:ClickListener): RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    var items:ArrayList<Persona>? = null
    var viewHolder:ViewHolder? = null

    init{
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.rv_template, parent,false)
        viewHolder = ViewHolder(vista, clickListener)
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

    class ViewHolder(vista: View, listener:ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener{


        var vista = vista

        var foto:ImageView? = null
        var nombre:TextView? = null

        var listener:ClickListener? =null

        init{
            foto = vista.iv_foto
            nombre = vista.tv_nombre
            this.listener = listener

            vista.setOnClickListener(this)
        }

        /* Implementar onClick*/

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

    }
}