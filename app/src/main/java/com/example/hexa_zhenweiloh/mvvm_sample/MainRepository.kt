package com.example.hexa_zhenweiloh.mvvm_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hexa_zhenweiloh.mvvm_sample.Room.RoomHelper
import com.example.hexa_zhenweiloh.mvvm_sample.Room.Table1Entity


/* Based on my understanding , the repository link the view model with the model.
 * Thus, View model do not know the present of the model.
 * View model only ask data from the repository.
 * The repository is act like a presenter that know the existing of view model and model and handle the data passing.
 * The repository mainly function is to get data from the From different model such as web service , room database and so on.
 * Repository module provide clean API to the rest of app */

class MainRepository {

    var mainModel: MainModel
    var roomhelper: RoomHelper

    constructor() {
        this.mainModel = MainModel()
        roomhelper = RoomHelper()
    }

    fun getData(): MutableLiveData<Human> {
        return mainModel.getSampleData()
    }

    fun getCounterData(): Int {
        return mainModel.getCounterCount()
    }

    fun insertRoomData(data:Table1Entity) {
        roomhelper.insert(data)
    }

    suspend fun getAllRoomData(): LiveData<List<Table1Entity>> {
      return  roomhelper.getTable1()
    }
}