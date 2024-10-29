package com.example.estudiantesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.estudiantesapp.databinding.ItemCursoBinding
import com.example.estudiantesapp.model.Curso

class CursoAdapter(private val cursos: List<Curso>) : RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {

    inner class CursoViewHolder(private val binding: ItemCursoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(curso: Curso) {
            binding.tvNombreCurso.text = curso.nombre
            binding.tvDocente.text = "Docente: ${curso.docente}"
            binding.tvCodigo.text = "Código: ${curso.codigo}"
            binding.tvSemestre.text = "Semestre: ${curso.semestre}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val binding = ItemCursoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CursoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        holder.bind(cursos[position])
    }

    override fun getItemCount() = cursos.size
}
