package com.umutcansahin.providemultiplebindingswithhilt.data

import android.util.Log
import com.umutcansahin.providemultiplebindingswithhilt.domain.DataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor() : DataSource {
    override fun getData() {
        Log.d("hiltHilt", "Remote Data")
    }
}