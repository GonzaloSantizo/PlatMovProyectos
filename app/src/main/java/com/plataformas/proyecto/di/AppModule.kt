package com.plataformas.proyecto.di


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.plataformas.proyecto.data.remote.api.AuthApi
import com.plataformas.proyecto.data.remote.firestore.FirestoreAuthApiImpl
import com.plataformas.proyecto.data.repository.auth.AuthRepository
import com.plataformas.proyecto.data.repository.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthProvider() : FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideAuthApi(auth: FirebaseAuth) : AuthApi = FirestoreAuthApiImpl(auth)

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi) : AuthRepository = AuthRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideApiProvider(): FirebaseFirestore = Firebase.firestore


}