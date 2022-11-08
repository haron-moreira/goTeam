package br.com.mobile.goteam

import android.app.Application

class GoTeamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: GoTeamApplication? = null

        fun getInstance(): GoTeamApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar no Android Manifest")
            }

            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}