package com.disney

import android.app.Application
import android.content.Context


/**
 * Created by gurkankesgin on 5.08.2024.
 */

class DisneyApplication : Application() {
    companion object {
        lateinit var instance: DisneyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getContext(): Context {
        return instance.applicationContext
    }
}

