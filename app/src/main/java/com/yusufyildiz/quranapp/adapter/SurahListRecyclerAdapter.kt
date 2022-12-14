package com.yusufyildiz.quranapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yusufyildiz.quranapp.R
import com.yusufyildiz.quranapp.databinding.SurahRecyclerRowBinding
import com.yusufyildiz.quranapp.model.Chapter
import com.yusufyildiz.quranapp.screens.list.SurahListFragmentDirections

class SurahListRecyclerAdapter(val surahList: ArrayList<Chapter>) : RecyclerView.Adapter<SurahListRecyclerAdapter.SurahListViewHolder>() {

    class SurahListViewHolder(val binding: SurahRecyclerRowBinding): ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahListViewHolder {
        val binding = SurahRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SurahListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahListViewHolder, position: Int) {
        val item = surahList[position]
        holder.binding.surahNameText.text = item.nameSimple.toString()
        holder.binding.surahRevelation.text = item.revelationPlace.toString()
        holder.binding.surahFirstPageText.text = item.pages.get(0).toString()
        holder.binding.surahSecondPageText.text = item.pages.get(1).toString()

        holder.itemView.setOnClickListener {
            val action = SurahListFragmentDirections.actionSurahListFragmentToSurahDetailFragment(item.id!!,item.nameSimple!!)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return surahList.size
    }

    fun updateSurahList(newSurahList: ArrayList<Chapter>)
    {
        surahList.clear()
        surahList.addAll(newSurahList)
        notifyDataSetChanged()

    }

}