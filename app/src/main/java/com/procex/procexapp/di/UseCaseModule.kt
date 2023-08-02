package com.procex.procexapp.di

import com.procex.procexapp.domain.repository.AuthRepository
import com.procex.procexapp.domain.repository.FormularioRepository
import com.procex.procexapp.domain.repository.UsersRepository
import com.procex.procexapp.domain.useCase.auth.AuthUseCase
import com.procex.procexapp.domain.useCase.auth.GetSessionDataUseCase
import com.procex.procexapp.domain.useCase.auth.LoginUseCase
import com.procex.procexapp.domain.useCase.auth.LogoutUseCase
import com.procex.procexapp.domain.useCase.auth.RegisterUseCase
import com.procex.procexapp.domain.useCase.auth.SaveSessionUseCase
import com.procex.procexapp.domain.useCase.auth.UpdateSessionUseCase
import com.procex.procexapp.domain.useCase.formulario.CreateFormularioUseCase
import com.procex.procexapp.domain.useCase.formulario.DeleteFormularioUseCase
import com.procex.procexapp.domain.useCase.formulario.FindByNumUseCase
import com.procex.procexapp.domain.useCase.formulario.FindByTypeAndNumUseCase
import com.procex.procexapp.domain.useCase.formulario.FindByTypeUseCase
import com.procex.procexapp.domain.useCase.formulario.FormularioUseCase
import com.procex.procexapp.domain.useCase.formulario.GetFormularioUseCase
import com.procex.procexapp.domain.useCase.formulario.UpdateFormularioUseCase
import com.procex.procexapp.domain.useCase.formulario.UpdateFormularioWithImageUseCase
import com.procex.procexapp.domain.useCase.users.UpdateUserUseCase
import com.procex.procexapp.domain.useCase.users.UpdateUserWithImageUseCase
import com.procex.procexapp.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

    @Provides
    fun provideFormularioUseCase(formularioRepository: FormularioRepository) = FormularioUseCase(
        createFormulario = CreateFormularioUseCase(formularioRepository),
        getFormulario = GetFormularioUseCase(formularioRepository),
        updateFormulario = UpdateFormularioUseCase(formularioRepository),
        updateFormularioWithImage = UpdateFormularioWithImageUseCase(formularioRepository),
        deleteFormulario = DeleteFormularioUseCase(formularioRepository),
        findByNum = FindByNumUseCase(formularioRepository),
        findByType = FindByTypeUseCase(formularioRepository),
        findByTypeAndNum = FindByTypeAndNumUseCase(formularioRepository)
    )

}