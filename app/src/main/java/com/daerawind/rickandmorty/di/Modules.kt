package com.daerawind.rickandmorty.di

import com.daerawind.rickandmorty.api.ApiService
import com.daerawind.rickandmorty.api.CharRemoteData
import com.daerawind.rickandmorty.api.CharRepo
import com.daerawind.rickandmorty.view.CharViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val myModules = module {
    single { buildRetrofit() }
    single { buildApiService(get()) }

    single { CharRemoteData(get()) }
    single { CharRepo(get()) }

    viewModel { CharViewModel(get()) }
}

private fun buildApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

private fun buildRetrofit(): Retrofit =
    Retrofit.Builder()
        .client(buildOkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(ApiService.BASE_URL)
        .build()

private fun buildOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .callTimeout(30, TimeUnit.SECONDS)
        .build()
