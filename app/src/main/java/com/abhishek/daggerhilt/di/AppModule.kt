package com.abhishek.daggerhilt.di

import com.abhishek.daggerhilt.models.Car
import com.abhishek.daggerhilt.models.Engine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun providesEngine() = Engine();

    @Provides
    fun providesCar() = Car()
}