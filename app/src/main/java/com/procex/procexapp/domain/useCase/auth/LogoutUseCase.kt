package com.procex.procexapp.domain.useCase.auth

import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke() = repository.logout()

}