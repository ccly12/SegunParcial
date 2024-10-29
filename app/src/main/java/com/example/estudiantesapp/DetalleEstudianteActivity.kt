package com.example.estudiantesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.estudiantesapp.adapter.CursoAdapter
import com.example.estudiantesapp.databinding.ActivityDetalleEstudianteBinding
import com.example.estudiantesapp.model.Estudiante

class DetalleEstudianteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleEstudianteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleEstudianteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val estudiante = intent.getParcelableExtra<Estudiante>("estudiante")
        estudiante?.let { mostrarDetalles(it) }
    }

    private fun mostrarDetalles(estudiante: Estudiante) {
        binding.tvNombreEstudiante.text = "${estudiante.primerNombre} ${estudiante.primerApellido} ${estudiante.segundoApellido}"
        binding.tvCarrera.text = "Carrera: ${estudiante.carrera}"
        binding.tvCarnet.text = "Carnet: ${estudiante.numeroCarnet}"
        binding.tvSede.text = "Sede: ${estudiante.sede}"
        binding.tvJornada.text = "Jornada: ${estudiante.jornada}"


        val cursoAdapter = CursoAdapter(estudiante.cursosMatriculados)
        binding.recyclerViewCursos.layoutManager = GridLayoutManager(this, 4)
        binding.recyclerViewCursos.adapter = cursoAdapter

        Glide.with(this)
            .load(estudiante.fotoPerfil)
            .into(binding.imageViewPerfil)
    }
}