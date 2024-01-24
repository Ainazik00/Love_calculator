package com.example.homework_2_5m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_2_5m.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getSerializableExtra("result") as? LoveModel

        if (result != null) {
            binding.tvName.text = result.firstName
            binding.tvNameGl.text = result.secondName
            binding.tvResult.text = result.result
            binding.tvPercentage.text = result.percentage
        } else {
            Toast.makeText(this, "Ошибка: Результат не был передан", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}
