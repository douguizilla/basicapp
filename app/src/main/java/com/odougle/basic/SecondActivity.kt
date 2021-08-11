package com.odougle.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.basic.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding: ActivitySecondBinding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val message = intent.getStringExtra("TEXT_FROM_ACTIVITY")
        var text = resources.getString(R.string.second_activity_message_text, message)
        binding.tvHello.text = text
    }
}