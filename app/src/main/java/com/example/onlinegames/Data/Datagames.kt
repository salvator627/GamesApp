package com.example.onlinegames.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Datagames(
    val title : String,
    val thumbnail : String,
    //data complex
    val platform : String,
    val publisher : String,
    val developer : String,
    val short_description : String,
    val release_date : String
):Parcelable
