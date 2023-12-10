package com.example.aplikasiandroidsederhana.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PCPartsModel(
    val name: String,
    val description: String,
    val photo: Int
):Parcelable