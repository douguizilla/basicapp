package com.odougle.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odougle.basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var message: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener{
            message = binding.edtText.text.toString()
            message?.let {
                createToast(it)
            }
        }

        binding.btnNextActivity.setOnClickListener {
            message = binding.edtText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT_FROM_ACTIVITY", message)
            startActivity(intent)
        }
    }

    private fun createToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}