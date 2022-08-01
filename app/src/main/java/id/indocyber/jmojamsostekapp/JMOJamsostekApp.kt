package id.indocyber.jmojamsostekapp

import android.app.Application
import id.indocyber.jmojamsostekapp.di.module.networkService
import id.indocyber.jmojamsostekapp.di.module.usecasemodule
import id.indocyber.jmojamsostekapp.di.module.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JMOJamsostekApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JMOJamsostekApp)
            modules(
                listOf(
                    vmModule,
                    networkService,
                    usecasemodule
                )
            )
        }
    }
}