package com.example.rickapi.endpoints

import com.example.rickapi.model.Character
import com.example.rickapi.model.ResponseAllCharacter
import com.example.rickapi.model.Location
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {
    @GET("character")
    fun getAllCharacter():Call<ResponseAllCharacter>

    @GET("character/2,183,15")
    fun getNCharacters():Call<List<Character>>

    @GET("location/2")
    fun getAllLocation():Call<Location>
}