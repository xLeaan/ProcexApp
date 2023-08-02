package com.procex.procexapp.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import com.procex.procexapp.data.repository.AuthRepositoryImpl
import com.procex.procexapp.data.repository.UsersRepositoryImpl
import com.procex.procexapp.data.dataSource.local.AuthLocalDataSource
import com.procex.procexapp.data.dataSource.local.FormularioLocalDataSource
import com.procex.procexapp.data.dataSource.remote.AuthRemoteDataSource
import com.procex.procexapp.data.dataSource.remote.FormularioRemoteDataSource
import com.procex.procexapp.data.dataSource.remote.UsersRemoteDataSource
import com.procex.procexapp.data.repository.FormularioRepositoryImpl
import com.procex.procexapp.domain.repository.AuthRepository
import com.procex.procexapp.domain.repository.FormularioRepository
import com.procex.procexapp.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideFormularioRepository(
        formularioRemoteDataSource: FormularioRemoteDataSource,
        formularioLocalDataSource: FormularioLocalDataSource,
        context: Context
    ): FormularioRepository = FormularioRepositoryImpl(formularioRemoteDataSource, formularioLocalDataSource, context)
}