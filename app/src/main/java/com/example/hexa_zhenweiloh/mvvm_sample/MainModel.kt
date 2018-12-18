package com.example.hexa_zhenweiloh.mvvm_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Jus a simple class that provide data .
 * In project, usually this class will be the class where the API call to get data been done. */
class MainModel {
    var test = MutableLiveData<Human>()
    var counter : Int =0

    fun getSampleData(): MutableLiveData<Human> {
        val humanA = Human(0)
        test.setValue(humanA)
        return  test
    }
    fun getCounterCount(): Int{
        ++ counter
        return counter
    }

}