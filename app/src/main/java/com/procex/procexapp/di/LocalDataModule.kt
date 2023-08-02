package com.procex.procexapp.di

import android.app.Application
import android.content.Context
import com.procex.procexapp.data.dataSource.local.datastore.AuthDatastore
import com.procex.procexapp.data.dataSource.local.AuthLocalDataSource
import com.procex.procexapp.data.dataSource.local.AuthLocalDataSourceImpl
import com.procex.procexapp.data.dataSource.local.FormularioLocalDataSource
import com.procex.procexapp.data.dataSource.local.FormularioLocalDataSourceImpl
import com.procex.procexapp.data.dataSource.local.dao.FormularioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideFormularioLocalDataSource(formularioDao: FormularioDao): FormularioLocalDataSource = FormularioLocalDataSourceImpl(formularioDao)

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}