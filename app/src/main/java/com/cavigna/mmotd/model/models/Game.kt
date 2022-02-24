package com.cavigna.mmotd.model.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "games_table")
data class Game(
    @PrimaryKey
    var id: Int = 0,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("thumbnail")
    var thumbnail: String = "",
    @SerializedName("short_description")
    var shortDescription: String = "",
    @SerializedName("game_url")
    var gameUrl: String = "",
    @SerializedName("genre")
    var genre: String = "",
    @SerializedName("platform")
    var platform: String = "",
    @SerializedName("publisher")
    var publisher: String = "",
    @SerializedName("developer")
    var developer: String = "",
    @SerializedName("release_date")
    var releaseDate: String = "",
    @SerializedName("profile_url")
    var profileUrl: String = ""
)