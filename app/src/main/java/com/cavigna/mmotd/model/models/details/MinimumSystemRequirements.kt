package com.cavigna.mmotd.model.models.details


import com.google.gson.annotations.SerializedName

data class MinimumSystemRequirements(
    @SerializedName("os")
    var os: String = "",
    @SerializedName("processor")
    var processor: String = "",
    @SerializedName("memory")
    var memory: String = "",
    @SerializedName("graphics")
    var graphics: String = "",
    @SerializedName("storage")
    var storage: String = ""
)