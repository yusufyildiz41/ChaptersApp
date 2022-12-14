package com.yusufyildiz.quranapp.model

import com.google.gson.annotations.SerializedName

data class Chapters(
    @SerializedName("chapters")
    val chapters : ArrayList<Chapter> = arrayListOf()
)