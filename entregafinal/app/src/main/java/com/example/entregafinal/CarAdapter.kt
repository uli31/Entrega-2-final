package com.example.entregafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.entregafinal.R

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    private var carList = emptyList<Car>()

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_car_adapter, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = carList [position]
        holder.itemView.apply {
            // Accedemos a las vistas utilizando los IDs definidos en item_car.xml
            val marca = findViewById<TextView>(R.id.brandTextView)
            val modelo = findViewById<TextView>(R.id.modelTextView)

            marca.text = currentItem.marca
            modelo.text = currentItem.modelo
            // Otros detalles del coche
        }
    }

    override fun getItemCount() = carList.size

    fun setData(newList: List<Car>) {
        carList = newList
        notifyDataSetChanged()
    }
}