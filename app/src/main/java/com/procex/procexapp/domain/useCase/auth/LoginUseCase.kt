package com.procex.procexapp.domain.useCase.auth

import com.procex.procexapp.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}