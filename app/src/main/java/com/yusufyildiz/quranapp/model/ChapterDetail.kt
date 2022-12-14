package com.yusufyildiz.quranapp.model

import com.google.gson.annotations.SerializedName

data class ChapterDetail(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("chapter_id")
    var chapterId: Int? = null,
    @SerializedName("language_name")
    var languageName: String? = null,
    @SerializedName("short_text")
    var shortText: String? = null,
    @SerializedName("source")
    var source: String? = null,
    @SerializedName("text")
    var text: String? = null
)