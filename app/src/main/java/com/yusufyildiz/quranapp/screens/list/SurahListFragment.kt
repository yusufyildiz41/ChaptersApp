package com.yusufyildiz.quranapp.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusufyildiz.quranapp.R
import com.yusufyildiz.quranapp.adapter.SurahListRecyclerAdapter
import com.yusufyildiz.quranapp.databinding.FragmentSurahListBinding
import com.yusufyildiz.quranapp.model.Chapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class SurahListFragment : Fragment() {


    private lateinit var binding : FragmentSurahListBinding
    private val surahListViewModel: SurahListViewModel by viewModels()
    private val surahListAdapter = SurahListRecyclerAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_surah_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initCollectors()

    }

    private fun initCollectors()
    {
        lifecycleScope.launchWhenStarted {
            surahListViewModel.chapterStateFlow.collect { chapters ->
                surahListRecyclerView(chapters)
            }
        }

    }

    private fun surahListRecyclerView(surahList: ArrayList<Chapter>)
    {
        binding.surahListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.surahListRecyclerView.adapter = surahListAdapter
        surahListAdapter.updateSurahList(surahList)
    }

}