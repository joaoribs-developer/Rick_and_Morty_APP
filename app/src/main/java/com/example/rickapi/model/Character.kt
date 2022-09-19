package com.example.rickapi.model

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Character(
    @SerializedName("id")
    val id:	Int,

    @SerializedName("name")
    val name:String,

    @SerializedName("status")
    val status:String,

    @SerializedName("species")
    val species:String,

    @SerializedName("type")
    val type:String,

    @SerializedName("gender")
    val gender:String,

    @SerializedName("origin")
    val origin: JSONObject,

    @SerializedName("location")
    val location:JSONObject,

    @SerializedName("image")
    val image: String,

    @SerializedName("episode")
    val episode: List<String>,

    @SerializedName("url")
    val url:String,

    @SerializedName("created")
    val created:String
)
