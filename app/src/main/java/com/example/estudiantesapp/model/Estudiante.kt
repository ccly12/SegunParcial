package com.example.estudiantesapp.model

import android.os.Parcel
import android.os.Parcelable

data class Estudiante(
    val primerNombre: String,
    val primerApellido: String,
    val segundoApellido: String,
    val carrera: String,
    val numeroCarnet: String,
    val sede: String,
    val jornada: String,
    val fotoPerfil: String,
    val cursosMatriculados: List<Curso>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createTypedArrayList(Curso.CREATOR) ?: arrayListOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(primerNombre)
        parcel.writeString(primerApellido)
        parcel.writeString(segundoApellido)
        parcel.writeString(carrera)
        parcel.writeString(numeroCarnet)
        parcel.writeString(sede)
        parcel.writeString(jornada)
        parcel.writeString(fotoPerfil)
        parcel.writeTypedList(cursosMatriculados)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Estudiante> {
        override fun createFromParcel(parcel: Parcel): Estudiante {
            return Estudiante(parcel)
        }

        override fun newArray(size: Int): Array<Estudiante?> {
            return arrayOfNulls(size)
        }
    }
}
