package com.odougle.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.basic.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding: ActivitySecondBinding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var clienteName = "Not received"
        var clienteAge = -1

        val client = intent.getParcelableExtra<Cliente>("client")
        client?.let { cliente ->
            clienteName = client.name.toString()
            clienteAge = client.age
        }
        val text = resources.getString(R.string.second_activity_message_text,clienteName, clienteAge)
        binding.tvMessage.text = text
    }
}