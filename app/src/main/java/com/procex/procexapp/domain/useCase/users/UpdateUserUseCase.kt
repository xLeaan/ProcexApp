package com.procex.procexapp.domain.useCase.users

import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.repository.UsersRepository

class UpdateUserUseCase constructor(private val repository: UsersRepository){

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}