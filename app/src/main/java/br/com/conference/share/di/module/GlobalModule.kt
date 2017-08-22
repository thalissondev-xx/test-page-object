package br.com.conference.share.di.module

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GlobalModule(private val view: Activity) {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideSharePreferences(): SharedPreferences {
        return view.getSharedPreferences("br.com.conference", Context.MODE_PRIVATE)
    }
}