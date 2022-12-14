package com.yusufyildiz.quranapp.service

import com.yusufyildiz.quranapp.model.ChapterInfo
import com.yusufyildiz.quranapp.model.Chapters
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChaptersAPI {

    @GET("api/v4/chapters?language=en")
    suspend fun getAllChapters(): Chapters

    @GET("api/v4/chapters/{chapter_id}/info")
    suspend fun getChapterInfo(@Path("chapter_id") chapterId: Int,@Query("language") language: String = "en") : ChapterInfo

}