package com.example.marvel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import com.example.marvel.login.view.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = findViewById<ImageView>(R.id.image_splashScreen)
        val logo = findViewById<ImageView>(R.id.image_logo_splashScreen)
        val text = findViewById<TextView>(R.id.txt_hqCollection_splash)

        background.animate().apply {
            duration = 3000
            scaleY(1.03f)
            scaleX(1.03f)
        }.withEndAction {
            background.animate().apply {
                duration = 1000
                alpha(0f)
            }
        }

        logo.animate().apply {
            duration = 6000
            alpha(1f)
            scaleY(1.05f)
            scaleX(1.05f)
        }
        text.animate().apply {
            duration = 5000
            alpha(1f)
        }



        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)

    }
}