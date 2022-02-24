package com.cavigna.mmotd.app

import android.content.Context
import androidx.room.Room
import com.cavigna.mmotd.model.local.db.BaseDeDatos
import com.cavigna.mmotd.model.remote.ApiService
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
object DataModule {

    @Singleton
    @Provides
    fun providesRetrofit(): ApiService = Retrofit.Builder()
        .baseUrl("https://www.mmobomb.com/api1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, BaseDeDatos::class.java, "games.db").build()

    @Singleton
    @Provides
    fun providesGameDao(db: BaseDeDatos) = db.dao
}