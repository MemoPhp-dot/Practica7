package com.example.practica7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniRpelis()
    }

    public fun iniRpelis(){
        var rvpelis = findViewById<RecyclerView>(R.id.gpelis)
        rvpelis.layoutManager = LinearLayoutManager(this)
        rvpelis.adapter = Adaptador(generaDatosPeli(),this)
    }

    private fun generaDatosPeli(): ArrayList<Pelicula>{
        var lista = ArrayList<Pelicula>()

        lista.add(Pelicula(R.drawable.peli1,"Titulo 01","Genero 01",1.5,"Detalle 01"))
        lista.add(Pelicula(R.drawable.peli2,"Titulo 02","Genero 02",2.5,"Detalle 02"))
        lista.add(Pelicula(R.drawable.peli3,"Titulo 03","Genero 03",3.5,"Detalle 03"))
        lista.add(Pelicula(R.drawable.peli4,"Titulo 04","Genero 04",4.5,"Detalle 04"))
        lista.add(Pelicula(R.drawable.peli5,"Titulo 05","Genero 05",5.0,"Detalle 05"))
        return lista

    }
}