package com.example.estudiantesapp.model

import android.os.Parcel
import android.os.Parcelable

data class Curso(
    val semestre: Int,
    val semestrePensum: Int,
    val creditos: Int,
    val nombre: String,
    val prerequisitos: List<String>,
    val codigo: String,
    val docente: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(semestre)
        parcel.writeInt(semestrePensum)
        parcel.writeInt(creditos)
        parcel.writeString(nombre)
        parcel.writeStringList(prerequisitos)
        parcel.writeString(codigo)
        parcel.writeString(docente)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Curso> {
        override fun createFromParcel(parcel: Parcel): Curso {
            return Curso(parcel)
        }

        override fun newArray(size: Int): Array<Curso?> {
            return arrayOfNulls(size)
        }
    }
}
