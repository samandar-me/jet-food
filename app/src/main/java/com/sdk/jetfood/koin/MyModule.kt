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
import java.util.concurrent.TimeUnit

val myModule = module {
    single {
        OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }
    single<JetService> {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/")
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