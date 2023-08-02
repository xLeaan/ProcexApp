package com.procex.procexapp.di

import android.app.Application
import androidx.room.Room
import com.procex.procexapp.data.dataSource.local.dao.FormularioDao
import com.procex.procexapp.data.dataSource.local.db.ProcexDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): ProcexDB =
        Room.databaseBuilder(app, ProcexDB::class.java,"procex_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideFormularioDao(db: ProcexDB): FormularioDao = db.formularioDao()



}