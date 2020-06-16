package com.meyoustu.opcvd

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Liangcheng Juves
 * Created at 2020/05/04 00:02
 */
class SplashActivity : AppCompatActivity() {

    private fun uiState() {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        uiState()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val thread = object : Thread() {
            override fun run() {
                super.run()
                sleep(1500)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }
        thread.start()
    }

    override fun onResume() {
        uiState()
        super.onResume()
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            uiState()
        }
        super.onWindowFocusChanged(hasFocus)
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        uiState()
        super.onConfigurationChanged(newConfig)
    }

}