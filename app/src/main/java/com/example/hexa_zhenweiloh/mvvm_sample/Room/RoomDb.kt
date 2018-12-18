package com.example.hexa_zhenweiloh.mvvm_sample.Room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Table1Entity::class), version = 1)
abstract class RoomDb : RoomDatabase() {
    abstract fun Table1Dao(): Table1Dao
}