package com.example.equipodefutbol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.RecyclerViewEquipos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(applicationContext)
        recyclerView.adapter =adapter

        adapter.submitList(getListadoEquipos())

        adapter.onItemClickListener = {equipo ->
//            Toast.makeText(this, equipo.name, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("apodo", equipo.apodo)
            intent.putExtra("url", equipo.url)
            startActivity(intent)
        }
    }

    private fun getListadoEquipos(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1,"River", 41, "El Millo","https://upload.wikimedia.org/wikipedia/commons/3/3f/Logo_River_Plate.png"),
            Equipo(2,"Boca", 46, "Bosteros","https://upload.wikimedia.org/wikipedia/commons/c/c9/Boca_escudo.png"),
            Equipo(3,"Racing", 39, "La acadamia", "https://i.pinimg.com/564x/fb/b0/ce/fbb0ce851cd75a40b6dc21ca439807e0.jpg"),
            Equipo(4,"Independiente", 38, "Los rojos","https://toppng.com/uploads/preview/ca-independiente-de-avellaneda-hd-logo-club-atletico-independiente-argentina-primera-divisio-11563202793xu9psnbi8l.png"),
            Equipo(5,"Fluminense", 30, "Muertos","https://upload.wikimedia.org/wikipedia/commons/a/ad/Fluminense_FC_escudo.png"),
            Equipo(6,"Santos", 38, "Los blancos" ,"https://upload.wikimedia.org/wikipedia/commons/1/15/Santos_Logo.png"),
            Equipo(7,"Nacional de Medellin", 30, "La verdolaga" ,"https://upload.wikimedia.org/wikipedia/commons/9/9a/Escudo_de_Atl%C3%A9tico_Nacional.png"),
            Equipo(8,"America de Cali", 32, "Los diablos rojos","https://upload.wikimedia.org/wikipedia/commons/c/c2/Am%C3%A9rica-de-Cali-Escudo.png"),
            Equipo(9,"Tigres", 25, "Los Tigresinhos","https://logodownload.org/wp-content/uploads/2019/02/club-tigres-uanl-logo-0.png"),
        )
    }
}