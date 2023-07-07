package com.umutcansahin.providemultiplebindingswithhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.umutcansahin.providemultiplebindingswithhilt.data.LocalDataSource
import com.umutcansahin.providemultiplebindingswithhilt.data.RemoteDataSource
import com.umutcansahin.providemultiplebindingswithhilt.di.Local
import com.umutcansahin.providemultiplebindingswithhilt.di.Remote
import com.umutcansahin.providemultiplebindingswithhilt.domain.DataSource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var localDataSourceWithDefault: LocalDataSource

    @Inject
    lateinit var remoteDataSourceWithDefault: RemoteDataSource

    @Inject
    @Local
    lateinit var localDataSourceWithQualifier: DataSource

    @Inject
    @Remote
    lateinit var remoteDataSourceWithQualifier: DataSource

    @Inject
    @Named("local")
    lateinit var localDataSourceWithNamed: DataSource

    @Inject
    @Named("remote")
    lateinit var remoteDataSourceWithNamed: DataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        localDataSourceWithDefault.getData()
        localDataSourceWithQualifier.getData()
        localDataSourceWithNamed.getData()

        remoteDataSourceWithDefault.getData()
        remoteDataSourceWithQualifier.getData()
        remoteDataSourceWithNamed.getData()
    }
}