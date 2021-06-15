package com.abhishek.daggerhilt.di

import com.abhishek.daggerhilt.models.Car
import com.abhishek.daggerhilt.models.Engine
import com.abhishek.daggerhilt.repository.DefaultMainRepository
import com.abhishek.daggerhilt.repository.MainRepository
import com.abhishek.daggerhilt.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://reqres.in/api/"

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesApi(): ApiInterface = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api: ApiInterface): MainRepository = DefaultMainRepository(api)

    @Provides
    fun providesEngine() = Engine();

    @Provides
    fun providesCar() = Car()

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}