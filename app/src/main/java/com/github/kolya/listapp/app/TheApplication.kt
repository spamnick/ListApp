package com.github.kolya.listapp.app

import android.app.Application
import com.github.kolya.listapp.BuildConfig
import com.github.kolya.listapp.di.apiRepoModule
import com.github.kolya.listapp.di.viewModelModule
import com.github.kolya.listapp.di.dataRepoModule
import com.github.kolya.listapp.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class TheApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        GlobalContext.startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@TheApplication)
            modules(
                viewModelModule,
                apiRepoModule,
                dataRepoModule,
                useCaseModule
            )
        }
    }
}