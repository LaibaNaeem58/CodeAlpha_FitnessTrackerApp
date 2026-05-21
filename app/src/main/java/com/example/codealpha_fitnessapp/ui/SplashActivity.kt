package com.example.codealpha_fitnessapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.codealpha_fitnessapp.R
import com.example.codealpha_fitnessapp.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.zoom_in))
        binding.tvAppName.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up))
        binding.tvTagline.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up))
        binding.tvDeveloper.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2500)
    }
}