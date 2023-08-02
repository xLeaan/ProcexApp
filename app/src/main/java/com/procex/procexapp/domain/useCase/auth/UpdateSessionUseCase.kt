package com.procex.procexapp.domain.useCase.auth

import com.procex.procexapp.domain.model.AuthResponse
import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.updateSession(user)

}