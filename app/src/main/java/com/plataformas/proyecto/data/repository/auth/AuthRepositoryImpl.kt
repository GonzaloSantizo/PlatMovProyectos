package com.plataformas.proyecto.data.repository.auth

import com.plataformas.proyecto.data.Resource
import com.plataformas.proyecto.data.remote.api.AuthApi


class AuthRepositoryImpl(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun signInWithEmailAndPassword(email: String, password: String) : String? {
        val authResponse = authApi.signInWithEmailAndPassword(email, password)

        return if (authResponse is Resource.Success)
            authResponse.data!!
        else
            null
    }
}