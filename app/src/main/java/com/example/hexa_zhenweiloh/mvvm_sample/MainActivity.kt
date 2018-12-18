package com.example.hexa_zhenweiloh.mvvm_sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.example.hexa_zhenweiloh.mvvm_sample.Room.RoomDb
import com.example.hexa_zhenweiloh.mvvm_sample.Room.RoomHelper
import com.example.hexa_zhenweiloh.mvvm_sample.Room.Table1Entity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var db: RoomDb
    }
    lateinit var roomhelper : RoomHelper
    private var counter=0
    private var counterReset =0
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(applicationContext, RoomDb::class.java, "Table1").allowMainThreadQueries().build()
        mainViewModel= MainViewModel()
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        roomhelper= RoomHelper()

       GlobalScope.launch(Dispatchers.Main) {
            var size= roomhelper.getTable1Test()
            tv_list_size.text= "Room Data List Size : ${size.size}"
        }


          GlobalScope.launch(Dispatchers.Main){
            mainViewModel.getRoomData().observe(this@MainActivity,object :Observer<List<Table1Entity>>{
                override fun onChanged(t: List<Table1Entity>?) {
                    tv_list_size_mvvm.text= "Room Data List Size : ${t?.size}"
                }
            })
        }


       btn_add_list_item.setOnClickListener{
            roomhelper.insert(Table1Entity(null,"ALI",5))
        }

        btn_delete_list_item.setOnClickListener{
            roomhelper.deleteTable()
        }

        val observer = Observer<Human> { newData ->
            tv_counter.text = newData.age.toString()
        }

        mainViewModel.data.observe(this, observer)

        btn_add.setOnClickListener{
            counter=mainViewModel.getCounterCount()
            counterReset++
            tv_no_mvvm_counter.text= counterReset.toString()
            mainViewModel.data.setValue(Human(counter))
        }

      //  var test : String  ?= null

      //  if (test!= null) a() else b()

     //   test?: a() ?: b()
    }

    fun a(){
        Log.d("test123","Function A")
    }

    fun b(){
        Log.d("test123","Function B")
    }

}
