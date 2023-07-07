package com.umutcansahin.providemultiplebindingswithhilt.di

import com.umutcansahin.providemultiplebindingswithhilt.domain.DataSource
import com.umutcansahin.providemultiplebindingswithhilt.data.LocalDataSource
import com.umutcansahin.providemultiplebindingswithhilt.data.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Local

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Remote

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRemoteWithDefault(): DataSource {
        return RemoteDataSource()
    }

    @Provides
    fun provideLocalWithDefault(): DataSource {
        return LocalDataSource()
    }

    @Provides
    @Remote
    fun provideRemoteWithQualifier(): DataSource {
        return RemoteDataSource()
    }

    @Provides
    @Local
    fun provideLocalWithQualifier(): DataSource {
        return LocalDataSource()
    }

    @Provides
    @Named("remote")
    fun provideRemoteWithNamed(): DataSource {
        return RemoteDataSource()
    }

    @Provides
    @Named("local")
    fun provideLocalWithNamed(): DataSource {
        return LocalDataSource()
    }
}