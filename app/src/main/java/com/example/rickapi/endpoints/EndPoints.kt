package com.example.rickapi.endpoints

import com.example.rickapi.model.Character
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {
    @GET("character/2")
    fun getAllCharacter():Call<Character>
}