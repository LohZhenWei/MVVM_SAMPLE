package com.example.hexa_zhenweiloh.mvvm_sample.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface Table1Dao :BaseDao<Table1Entity> {

    @Query("SELECT * FROM Table1")
    fun getAll(): LiveData<List<Table1Entity>>

    @Query("DELETE FROM Table1")
    fun deleteTable()

    @Query("SELECT * FROM Table1")
    fun getAllTest():List<Table1Entity>
}