package com.yusufyildiz.quranapp.model

import com.google.gson.annotations.SerializedName

data class Chapter(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("revelation_place")
    val revelationPlace: String? = null,
    @SerializedName("revelation_order")
    val revelationOrder: Int? = null,
    @SerializedName("bismillah_pre")
    val bismillahPre: Boolean? = null,
    @SerializedName("name_simple")
    val nameSimple: String? = null,
    @SerializedName("name_complex")
    val nameComplex: String? = null,
    @SerializedName("name_arabic")
    val nameArabic: String? = null,
    @SerializedName("verses_count")
    val versesCount: Int? = null,
    @SerializedName("pages")
    val pages: ArrayList<Int> = arrayListOf(),
    @SerializedName("translated_name")
    val translatedName: TranslatedName? = TranslatedName()
)