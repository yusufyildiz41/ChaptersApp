package com.yusufyildiz.quranapp.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufyildiz.quranapp.model.ChapterDetail
import com.yusufyildiz.quranapp.service.ChaptersAPIHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahDetailViewModel @Inject constructor(
     private val chaptersAPIHelper: ChaptersAPIHelper
) : ViewModel() {

    private val _chapterInfoStateFlow = MutableStateFlow(ChapterDetail())
    val chapterInfoStateFlow = _chapterInfoStateFlow.asStateFlow()

    fun getChapterInfo(chapterId: Int) {
        viewModelScope.launch {
            chaptersAPIHelper.getChapterInfo(chapterId).collect { chapterInfo ->
                chapterInfo.chapterDetail?.let { chapterDetail ->
                    _chapterInfoStateFlow.value = chapterDetail
                }
            }
        }

    }
}