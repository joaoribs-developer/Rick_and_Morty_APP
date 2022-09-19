package com.example.rickapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickapi.Network.RetrofitService
import com.example.rickapi.endpoints.EndPoints
import com.example.rickapi.model.Character
import com.example.rickapi.model.ResponseAllCharacter
import com.example.rickapi.model.Location
import com.example.rickapi.ui.theme.RickAPITheme
import retrofit2.Call
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CardView()
        getLocation()
        getNCharacters()
        setContent {
            RickAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                }
            }
        }
    }


    @Composable
    fun MainContent() {


    }


    fun CardView() {
        val retrofitService = RetrofitService.getRetrofitInstance()
        retrofitService.create(EndPoints::class.java).getAllCharacter()
            .enqueue(object : retrofit2.Callback<ResponseAllCharacter>{
                override fun onResponse(call: Call<ResponseAllCharacter>, response: Response<ResponseAllCharacter>) {
                    var resp = response.body()
                    println(resp)
                }

                override fun onFailure(call: Call<ResponseAllCharacter>, t: Throwable) {
                    println("não foi")
                }

            })


    }

    fun getLocation(){
        val retrofitService = RetrofitService.getRetrofitInstance()
        retrofitService.create(EndPoints::class.java).getAllLocation().enqueue(object : retrofit2.Callback<Location>{
            override fun onResponse(
                call: Call<Location>,
                response: Response<Location>
            ) {
                var resp = response.body()
                println(resp)
            }

            override fun onFailure(call: Call<Location>, t: Throwable) {
                println("não foi")
            }

        })
    }

    fun getNCharacters(){
        val retrofitService = RetrofitService.getRetrofitInstance()
        retrofitService.create(EndPoints::class.java).getNCharacters().enqueue(object : retrofit2.Callback<List<Character>>{
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                var resp = response.body()
                println(resp)
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                println("não foi")
            }
        })
    }
}

