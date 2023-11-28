package com.example.onlinegames.Api

import com.example.onlinegames.Data.Datagames
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("games?category=mmorpg")
    fun mmorpg(): Call<ArrayList<Datagames>>

    @GET("games?category=action")
    fun action(): Call<ArrayList<Datagames>>
}