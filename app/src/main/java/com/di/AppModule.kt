package com.di

import android.content.Context
import android.content.SharedPreferences
import com.onboarding.adapter.OnBoardingPref
import com.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Provides
    @Singleton
    fun provideOnBoardingPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("PREF_KEY", Context.MODE_PRIVATE)
    }

}