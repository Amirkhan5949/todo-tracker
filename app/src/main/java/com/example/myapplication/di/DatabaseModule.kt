package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.data.TaskDao
import com.example.myapplication.data.TaskDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDataBase(application: Application): TaskDataBase {
        return Room.databaseBuilder(application, TaskDataBase::class.java, "my_database.db").build()
    }

    @Provides
    fun provideTaskDao(appDataBase: TaskDataBase): TaskDao {
        return appDataBase.taskDao()
    }
}