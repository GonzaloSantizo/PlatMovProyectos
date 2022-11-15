package com.plataformas.proyecto.data.repository.auth

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.plataformas.proyecto.data.Resource
import com.plataformas.proyecto.data.remote.api.AuthApi


class AuthRepositoryImpl(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun signInWithEmailAndPassword(email: String, password: String): String? {
        val authResponse = authApi.signInWithEmailAndPassword(email, password)

        return if (authResponse is Resource.Success)
            authResponse.data!!
        else
            null
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): String? {
        val authResponse = authApi.createUserWithEmailAndPassword(email, password)

        return if (authResponse is Resource.Success)
            authResponse.data!!
        else
            null
    }


}