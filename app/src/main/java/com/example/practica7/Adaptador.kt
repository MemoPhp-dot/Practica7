package com.example.practica7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador(private var lista:ArrayList<Pelicula>, private var contexto:Context):
    RecyclerView.Adapter<Adaptador.vercontenido>()
{

    class vercontenido(var vista:View, var contexto:Context):RecyclerView.ViewHolder(vista){

        var ctitulo = vista.findViewById<TextView>(R.id.gtitulo)
        var cgenero = vista.findViewById<TextView>(R.id.ggenero)
        var ccalific = vista.findViewById<RatingBar>(R.id.gcalif)
        var cimag = vista.findViewById<ImageView>(R.id.gimagen)

        fun bind(pelicula: Pelicula){
            ctitulo.text = pelicula.title
            cgenero.text = pelicula.genero
            ccalific.rating = pelicula.calificacion.toFloat()
            cimag.setImageResource(pelicula.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vercontenido {
       return vercontenido(LayoutInflater.from(parent.context).inflate(R.layout.listapelis,
           parent,false),contexto)
    }

    override fun getItemCount(): Int {
      return lista.size
    }

    override fun onBindViewHolder(holder: vercontenido, position: Int) {
        holder.bind(lista[position])
    }
}