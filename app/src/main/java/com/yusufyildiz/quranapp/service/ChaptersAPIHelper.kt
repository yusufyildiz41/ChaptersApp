package com.yusufyildiz.quranapp.service

import com.yusufyildiz.quranapp.model.ChapterInfo
import com.yusufyildiz.quranapp.model.Chapters
import kotlinx.coroutines.flow.Flow


interface ChaptersAPIHelper {

    fun getAllChapters(): Flow<Chapters>

    fun getChapterInfo(chapterId: Int): Flow<ChapterInfo>

}