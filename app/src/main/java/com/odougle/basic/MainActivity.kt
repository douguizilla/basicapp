package com.odougle.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odougle.basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var clientName: String? = null
    private var clientAge: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener{
            clientName = binding.edtClientNameText.text.toString()
            clientName?.let {
                createToast(it)
            }
        }

        binding.btnNextActivity.setOnClickListener {
            clientName = binding.edtClientNameText.text.toString()
            clientAge = binding.edtClientAgeText.text.toString()

            if(clientName.isNullOrEmpty() or clientAge.isNullOrEmpty()){
                createToast("Fill the fields!")
            }else{
                var age = clientAge!!.toInt()
                var name = clientName!!
                val client = Cliente(name, age)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("client", client)
                startActivity(intent)
            }
        }

    }

    private fun createToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}