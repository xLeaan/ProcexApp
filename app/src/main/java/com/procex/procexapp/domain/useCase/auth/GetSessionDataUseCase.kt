package com.procex.procexapp.domain.useCase.auth

import com.procex.procexapp.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.getSessionData()

}