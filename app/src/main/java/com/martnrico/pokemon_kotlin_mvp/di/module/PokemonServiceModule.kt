package com.martnrico.pokemon_kotlin_mvp.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.martnrico.pokemon_kotlin_mvp.data.PokemonService
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Martín Rico Martínez on 23/03/2019.
 */
@Module
class PokemonServiceModule {

    private val BASE_URL = "http://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(callFactory: Call.Factory, @Named("base_url") baseUrl: String): Retrofit {
        return retrofit2.Retrofit.Builder()
            .callFactory(callFactory)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()
                )
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttp(): Call.Factory {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Named("base_url")
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Provides
    @Named("network_scheduler")
    fun provideNetworkShecduler(): Scheduler {
        return Schedulers.io()
    }
}