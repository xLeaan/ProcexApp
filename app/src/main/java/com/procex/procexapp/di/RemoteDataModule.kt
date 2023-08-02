package com.procex.procexapp.di

import com.procex.procexapp.data.dataSource.remote.AuthRemoteDataSource
import com.procex.procexapp.data.dataSource.remote.FormularioRemoteDataSource
import com.procex.procexapp.data.dataSource.remote.UsersRemoteDataSource
import com.procex.procexapp.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.procex.procexapp.data.dataSource.remote.FormularioRemoteDataSourceImpl
import com.procex.procexapp.data.dataSource.remote.UsersRemoteDataSourceImpl
import com.procex.procexapp.data.dataSource.remote.service.AuthService
import com.procex.procexapp.data.dataSource.remote.service.FormularioService
import com.procex.procexapp.data.dataSource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource = UsersRemoteDataSourceImpl(usersService)

    @Provides
    fun provideFormularioRemoteDataSource(formularioService: FormularioService): FormularioRemoteDataSource = FormularioRemoteDataSourceImpl(formularioService)
}