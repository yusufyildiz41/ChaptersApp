package com.yusufyildiz.quranapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yusufyildiz.quranapp.R
import com.yusufyildiz.quranapp.databinding.FragmentSurahDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SurahDetailFragment : Fragment() {

    private lateinit var binding: FragmentSurahDetailBinding
    private val surahDetailViewModel : SurahDetailViewModel by viewModels()

    private var chapterId: Int?=null
    private var chapterName: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            chapterId = SurahDetailFragmentArgs.fromBundle(it).chapterId
            chapterName = SurahDetailFragmentArgs.fromBundle(it).name
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_surah_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chapterId?.let {
            surahDetailViewModel.getChapterInfo(it)
        }

        initCollectors()

    }

    private fun initCollectors()
    {
        lifecycleScope.launchWhenStarted {
            surahDetailViewModel.chapterInfoStateFlow.collect{ chapterDetail ->
                binding.surahNameDetailTextView.text = chapterName.toString()
                binding.sourceDetailTextView.text = chapterDetail.source.toString()
                binding.longDetailTextView.text = chapterDetail.text.toString()
                binding.shortDetailTextView.text = chapterDetail.shortText.toString()
            }
        }
    }


}