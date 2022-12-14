package com.yusufyildiz.quranapp.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufyildiz.quranapp.model.Chapter
import com.yusufyildiz.quranapp.service.ChaptersAPIHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahListViewModel @Inject constructor(
    private val chaptersAPIHelper: ChaptersAPIHelper
) : ViewModel() {

    private val _chapterFlowState = MutableStateFlow(arrayListOf<Chapter>())
    val chapterStateFlow = _chapterFlowState.asStateFlow()


    init {
        fetchChapters()
    }

    fun fetchChapters() {
        viewModelScope.launch {
            chaptersAPIHelper.getAllChapters()
                .collect { it ->
                    _chapterFlowState.value = it.chapters
                }
        }
    }


}