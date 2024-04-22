package com.example.entregafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.entregafinal.CarAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) // Obtén la referencia al RecyclerView inflado
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = CarAdapter()
        recyclerView.adapter = adapter

        fetchCars()
    }

    private fun fetchCars() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val cars = ApiClient.carService.getCars()
                withContext(Dispatchers.Main) {
                    adapter.setData(cars)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Manejar el error de conexión aquí
            }
        }
    }
}