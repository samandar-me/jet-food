package com.sdk.jetfood.koin

import com.sdk.jetfood.data.JetRepositoryImpl
import com.sdk.jetfood.data.remote.JetService
import com.sdk.jetfood.domain.repository.JetRepository
import com.sdk.jetfood.presentation.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val myModule = module {
    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }
    single<JetService> {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/vipulasri/8bd2115e50fd73272ea8de08cd54b9d5/raw/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
            .create(JetService::class.java)
    }
    factory<JetRepository> { JetRepositoryImpl(get()) }
    viewModel {
        HomeViewModel(get())
    }
}