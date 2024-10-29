package com.example.estudiantesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.estudiantesapp.model.Estudiante
import com.example.estudiantesapp.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EstudianteViewModel : ViewModel() {
    private val _estudiantes = MutableLiveData<List<Estudiante>>()
    val estudiantes: LiveData<List<Estudiante>> get() = _estudiantes

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    private val apiService = ApiService.create()

    fun obtenerEstudiantes() {
        _errorMessage.value = null

        apiService.obtenerEstudiantes().enqueue(object : Callback<List<Estudiante>> {
            override fun onResponse(call: Call<List<Estudiante>>, response: Response<List<Estudiante>>) {
                if (response.isSuccessful) {
                    _estudiantes.value = response.body()
                } else {
                    _errorMessage.value = "Error: ${response.code()} ${response.message()}"
                }
            }

            override fun onFailure(call: Call<List<Estudiante>>, t: Throwable) {
                _errorMessage.value = "Error de conexión: ${t.message}"
            }
        })
    }
}