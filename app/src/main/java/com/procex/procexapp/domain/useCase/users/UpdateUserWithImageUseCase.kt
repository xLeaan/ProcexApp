package com.procex.procexapp.domain.useCase.users

import com.procex.procexapp.domain.model.User
import com.procex.procexapp.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase constructor(private val repository: UsersRepository){

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)

}