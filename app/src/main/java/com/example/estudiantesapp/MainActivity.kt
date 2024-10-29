package com.example.estudiantesapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.estudiantesapp.adapter.EstudianteAdapter
import com.example.estudiantesapp.databinding.ActivityMainBinding
import com.example.estudiantesapp.model.Estudiante
import com.example.estudiantesapp.interfaces.OnEstudianteClickListener
import com.example.estudiantesapp.viewModel.EstudianteViewModel

class MainActivity : AppCompatActivity(), OnEstudianteClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: EstudianteViewModel by viewModels()
    private lateinit var adapter: EstudianteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EstudianteAdapter(emptyList(), this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.estudiantes.observe(this) { estudiantes ->
            adapter = EstudianteAdapter(estudiantes, this)
            binding.recyclerView.adapter = adapter
        }

        viewModel.obtenerEstudiantes()
    }

    override fun onEstudianteClick(estudiante: Estudiante) {
        val intent = Intent(this, DetalleEstudianteActivity::class.java)
        intent.putExtra("estudiante", estudiante)
        startActivity(intent)
    }
}
