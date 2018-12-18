package com.example.hexa_zhenweiloh.mvvm_sample.Room

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.hexa_zhenweiloh.mvvm_sample.MainActivity.Companion.db
import kotlinx.coroutines.*


class RoomHelper {

    fun insert (data : Table1Entity ){
        GlobalScope.launch{
            db.Table1Dao().insert(data)
            Log.d("test123","test123")
        }
    }

    fun delete(data : Table1Entity){
        GlobalScope.launch{
            db.Table1Dao().delete(data)
        }
    }

    fun deleteTable(){
        GlobalScope.launch{
            db.Table1Dao().deleteTable()
        }
    }


    fun update(data : Table1Entity){
        GlobalScope.launch{
            db.Table1Dao().update(data)
        }
    }


    suspend fun getTable1(): LiveData<List<Table1Entity>>{
        var data = db.Table1Dao().getAll()
        return data
    }

    suspend  fun getTable1Test():List<Table1Entity>{
        var data = db.Table1Dao().getAllTest()
        return data
    }

}