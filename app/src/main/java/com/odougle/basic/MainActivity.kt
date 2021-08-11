package com.odougle.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.odougle.basic.databinding.ActivityMainBinding
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var clientName: String? = null
    private var clientPhone: String? = null
    private var clientAddress: String? = null
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
            clientPhone = binding.edtClientPhoneText.text.toString()
            clientAddress = binding.edtClientAddressText.text.toString()

            if(clientName.isNullOrEmpty() or clientPhone.isNullOrEmpty() or clientAddress.isNullOrEmpty()){
                createToast("Fill the fields!")
            }else{
                val client = Cliente(clientName!!, clientPhone!!, clientAddress!!)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("client", Parcels.wrap(client))
                startActivity(intent)
            }
        }

    }

    private fun createToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}