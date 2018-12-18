package com.example.hexa_zhenweiloh.mvvm_sample


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hexa_zhenweiloh.mvvm_sample.Room.Table1Entity

/* View model responsible for preparing data for the UI/View
 * It extend View Model  . Thus it automatically having their holding data retained during configuration changes.
 * Live Data is an Observable data holder.
 * This allows the components in your app to be able to observe LiveData objects for changes without creating explicit
   and rigid dependency paths between them
 * Since LiveData respects Android Lifecycle, this means it will not invoke its observer callback unless the LiveData host
   (activity or fragment) is in an active state (received onStart() but did not receive onStop() for example).
 * Adding to this, LiveData will also automatically remove the observer when the its host receives onDestroy().*/
class MainViewModel() : ViewModel() {

    private lateinit var mainRepository: MainRepository
    var data : MutableLiveData<Human>

    init {
        mainRepository= MainRepository()
        data=mainRepository.getData()
    }

    fun getRepoData() :LiveData<Human>{
        return data;
    }
    fun getCounterCount(): Int{
        return mainRepository.getCounterData()
    }
    fun insertRoomData(data: Table1Entity){
        mainRepository.insertRoomData(data)
    }

    suspend fun getRoomData() :LiveData<List<Table1Entity>>{
        return mainRepository.getAllRoomData()
    }
}