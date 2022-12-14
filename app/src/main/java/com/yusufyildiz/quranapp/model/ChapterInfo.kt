package com.yusufyildiz.quranapp.model

import com.google.gson.annotations.SerializedName

data class ChapterInfo(
    @SerializedName("chapter_info")
    var chapterDetail: ChapterDetail? = ChapterDetail()
)