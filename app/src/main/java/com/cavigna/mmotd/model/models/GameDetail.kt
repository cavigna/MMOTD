package com.cavigna.mmotd.model.models


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cavigna.mmotd.model.models.details.MinimumSystemRequirements
import com.cavigna.mmotd.model.models.details.Screenshot
import com.google.gson.annotations.SerializedName

@Entity(tableName = "game_details_table")
data class GameDetail(

    @PrimaryKey
    var id: Int = 0,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("thumbnail")
    var thumbnail: String = "",
    @SerializedName("status")
    var status: String = "",
    @SerializedName("short_description")
    var shortDescription: String = "",
    @SerializedName("description")
    var description: String = "",
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
    var profileUrl: String = "",

    @Embedded
    @SerializedName("minimum_system_requirements")
    var minimumSystemRequirements: MinimumSystemRequirements = MinimumSystemRequirements(),


    @SerializedName("screenshots")
    var screenshots: List<Screenshot> = listOf()
)