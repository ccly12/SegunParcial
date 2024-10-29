package com.example.estudiantesapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.estudiantesapp.model.Estudiante
import com.example.estudiantesapp.databinding.ItemEstudianteBinding
import com.example.estudiantesapp.interfaces.OnEstudianteClickListener

class EstudianteAdapter(private val estudiantes: List<Estudiante>, private val listener: OnEstudianteClickListener) :
    RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder>() {

    inner class EstudianteViewHolder(private val binding: ItemEstudianteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(estudiante: Estudiante) {
            binding.tvNombreEstudiante.text = "${estudiante.primerNombre} ${estudiante.primerApellido}"
            binding.btnIr.setOnClickListener {
                listener.onEstudianteClick(estudiante)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstudianteViewHolder {
        val binding = ItemEstudianteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EstudianteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EstudianteViewHolder, position: Int) {
        holder.bind(estudiantes[position])
    }

    override fun getItemCount() = estudiantes.size
}
