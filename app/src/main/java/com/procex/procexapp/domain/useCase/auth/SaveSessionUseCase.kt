package com.procex.procexapp.domain.useCase.auth

import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)

}