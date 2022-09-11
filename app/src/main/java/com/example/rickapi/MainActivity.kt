package com.example.rickapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickapi.Network.RetrofitService
import com.example.rickapi.endpoints.EndPoints
import com.example.rickapi.model.Character
import com.example.rickapi.ui.theme.RickAPITheme
import retrofit2.Call
import retrofit2.Response
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CardView()
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
            .enqueue(object : retrofit2.Callback<Character>{
                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    var resp = response.body()
                    println(resp)
                }

                override fun onFailure(call: Call<Character>, t: Throwable) {
                    println("não foi")
                }

            })


    }
}

