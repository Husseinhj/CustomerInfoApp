package com.husseinhj.customerinfoapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import com.husseinhj.customerinfoapp.common.Constants
import com.husseinhj.customerinfoapp.data.remote.UserApiService
import com.husseinhj.customerinfoapp.data.repository.UserRepositoryImpl
import com.husseinhj.customerinfoapp.domain.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: UserApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }

}