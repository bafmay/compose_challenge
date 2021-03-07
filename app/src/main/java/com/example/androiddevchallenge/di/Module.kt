package com.example.androiddevchallenge.di

import com.example.androiddevchallenge.utils.PuppyDataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Module {

    @Provides
    @Singleton
    fun providePuppyDataManager() = PuppyDataManager
}