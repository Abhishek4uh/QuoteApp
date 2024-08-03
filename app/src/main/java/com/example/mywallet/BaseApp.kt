package com.example.mywallet

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp:Application(){

    companion object{
        private const val TAG="BaseApp"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"BaseApp_onCreate")
    }
}