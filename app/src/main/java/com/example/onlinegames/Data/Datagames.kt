package com.example.onlinegames.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Datagames(
    val title : String,
    val thumbnail : String,
    //data complex
    val platform : String
):Parcelable
