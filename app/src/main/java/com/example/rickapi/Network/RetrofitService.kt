package com.example.rickapi.Network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService{
    companion object{
        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}