package com.veegadiego.herolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.veegadiego.herolist.Adapter.PersonaAdapter
import com.veegadiego.herolist.Models.Persona

class MainActivity : AppCompatActivity() {

    var personas:ArrayList<Persona>? = null

    var lista:RecyclerView? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    var adaptador: PersonaAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personas = ArrayList()

        personas?.add(Persona("Iron-Man", R.drawable.icon))
        personas?.add(Persona("Black Widow", R.drawable.icon))
        personas?.add(Persona("Hulk", R.drawable.icon))
        personas?.add(Persona("HawkEye", R.drawable.icon))
        personas?.add(Persona("Thortilla", R.drawable.icon))
        personas?.add(Persona("Capitan America", R.drawable.icon))

        lista = findViewById(R.id.lista)
        layoutManager = LinearLayoutManager(this)
        adaptador = PersonaAdapter(personas!!)
        lista?.layoutManager = layoutManager
        lista?.adapter = adaptador
    }
}
