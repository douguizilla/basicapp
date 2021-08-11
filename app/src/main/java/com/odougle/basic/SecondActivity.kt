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
        fillActivityMessage()

    }

    private fun fillActivityMessage(){
        var clienteName = "Not received"
        var clienteAge = -1

        val client = Parcels.unwrap<Cliente?>(intent.getParcelableExtra("client"))
        client?.let {
            clienteName = it.name
            clienteAge = it.age
        }
        val text = resources.getString(R.string.second_activity_message_text,clienteName, clienteAge)
        binding.tvMessage.text = text
    }
}