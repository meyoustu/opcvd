package com.meyoustu.opcvd

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.opencv.core.Core

/**
 * @author Liangcheng Juves
 * Created at 2020/05/04 00:02
 */
class MainActivity : AppCompatActivity() {

    init {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
    }

    private fun uiState() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or
                View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        uiState()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        version.text = Core.VERSION + " " + Core.VERSION_STATUS
    }
}
