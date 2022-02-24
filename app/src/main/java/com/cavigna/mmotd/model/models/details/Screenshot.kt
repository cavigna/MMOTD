package com.cavigna.mmotd.model.models.details


import com.google.gson.annotations.SerializedName

data class Screenshot(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image")
    var image: String = ""
)