package com.odougle.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odougle.basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener{
            var message: String? = binding.edtText.text.toString()
            message?.let {
                createToast(it)
            }
        }
    }



    private fun createToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}