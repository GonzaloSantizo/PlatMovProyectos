package com.plataformas.proyecto.data.remote.api

import com.plataformas.proyecto.data.Resource

interface AuthApi {
    suspend fun signInWithEmailAndPassword(email: String, password: String) : Resource<String>
}