package com.yusufyildiz.quranapp.model

import com.google.gson.annotations.SerializedName

data class TranslatedName(
    @SerializedName("language_name")
    val languageName: String? = null,
    @SerializedName("name")
    val name: String? = null
)