package com.example.rickapi.model

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject

data class ResponseAllCharacter(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character>
)
