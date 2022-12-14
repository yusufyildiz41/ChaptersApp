package com.yusufyildiz.quranapp.service
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChaptersAPIHelperImpl
    @Inject constructor(private val apiService: ChaptersAPI) : ChaptersAPIHelper {

    override fun getAllChapters() = flow {
        emit(apiService.getAllChapters())
    }

    override fun getChapterInfo(chapterId: Int) = flow {
        emit(apiService.getChapterInfo(chapterId))
    }
}