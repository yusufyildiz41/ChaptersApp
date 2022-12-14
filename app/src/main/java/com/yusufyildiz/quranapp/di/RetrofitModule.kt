package com.yusufyildiz.quranapp.di

import com.yusufyildiz.quranapp.BASE_URL
import com.yusufyildiz.quranapp.service.ChaptersAPI
import com.yusufyildiz.quranapp.service.ChaptersAPIHelper
import com.yusufyildiz.quranapp.service.ChaptersAPIHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    @Provides
    @Singleton
    fun provideChapterAPIService(retrofit: Retrofit): ChaptersAPI =
        retrofit.create(ChaptersAPI::class.java)

    @Provides
    @Singleton
    fun provideChapterApiImpl(
        chaptersAPI: ChaptersAPI
    ):ChaptersAPIHelper = ChaptersAPIHelperImpl(chaptersAPI)


}