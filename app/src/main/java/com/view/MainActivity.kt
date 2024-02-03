package com.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.LoveViewModel
import com.Repository
import com.example.homework_2_5m.databinding.ActivityMainBinding
import com.onboarding.OnBoardingActivity
import com.onboarding.adapter.OnBoardingPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var repository: Repository
    @Inject
    lateinit var onBoardingPref: OnBoardingPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!onBoardingPref.isOnboardingCompleted()){
            startActivity(Intent(this@MainActivity,OnBoardingActivity::class.java))
        }
        initClicker()

    }

    @SuppressLint("SetTextI18n")
    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                repository.getLoveModel(
                    firstName = binding.etName.text.toString(),
                    secondName = binding.etNameGl.text.toString()
                ).observe(this@MainActivity, Observer {
                    it?.let { model ->
                        tvLove.text =
                            "${model.fname} \n ${model.sname} \n ${model.percentage} \n ${model.result}"
                    }
                })
            }
        }
    }

}