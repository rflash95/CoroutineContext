package com.teknorial.coroutinecontext

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = "MainActivity"

        /*
        * Coroutine Context
        * Berdasarkan yang akan dilakukan oleh coroutine kita, ada beberapa Dispatchers :
        * 1. Main = Coroutine akan dijalankan di Main Thread, berguna untuk UI Operation
        * 2. I/O = Coroutine yang berguna untuk data operation seperti update database
        *          atau reading & writing files
        * 3. Default = Digunakan untuk complex atau long running calculation untuk tidak
        *              block Main Thread dan UI kita
        * 4. Unconfined = Coroutine tidak dibatasi pada Thread manapun
        * */

         GlobalScope.launch(Dispatchers.IO) {
             val answer = doNetworkCall()
             Log.d(TAG, "Starting coroutine in thread ${Thread.currentThread().name}")

             //switch to Main Thread (withContext())
             withContext(Dispatchers.Main){
                 Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
                 tvDummy.text = answer

             }
         }

    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }
}