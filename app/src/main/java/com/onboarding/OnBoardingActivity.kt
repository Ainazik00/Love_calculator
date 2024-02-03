package com.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.homework_2_5m.R
import com.example.homework_2_5m.databinding.ActivityMainBinding
import com.example.homework_2_5m.databinding.ActivityOnBoardingBinding
import com.onboarding.adapter.OnBoardingAdapter
import com.onboarding.adapter.OnBoardingPref
import com.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {

    @Inject
    lateinit var onBoardingPref: OnBoardingPref
    private var adapter = OnBoardingAdapter(this::onClick)

    private lateinit var binding: ActivityOnBoardingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun onClick(){
        onBoardingPref.setOnboardingCompleted()
        startActivity(Intent(this@OnBoardingActivity,MainActivity::class.java))
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = adapter
    }


    private fun startMainActivity() {
        startActivity(Intent(this@OnBoardingActivity, MainActivity::class.java))
        finish()
    }
}
