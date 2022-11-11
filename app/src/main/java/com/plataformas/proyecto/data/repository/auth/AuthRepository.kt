package com.plataformas.proyecto.data.repository.auth

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String) : String?
}