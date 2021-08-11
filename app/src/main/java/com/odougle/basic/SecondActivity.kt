package com.odougle.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.basic.databinding.ActivitySecondBinding
import org.parceler.Parcels

class SecondActivity : AppCompatActivity() {
    private val binding: ActivitySecondBinding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = Parcels.unwrap<Cliente?>(intent.getParcelableExtra("client"))
        fillActivityMessage(client)

    }

    private fun fillActivityMessage(client: Cliente?){
        client?.let {
            val text = resources.getString(R.string.second_activity_message_text,it.name, it.phoneNumber, it.address)
            binding.tvMessage.text = text
        }
    }
}