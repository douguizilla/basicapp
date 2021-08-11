package com.odougle.basic

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.odougle.basic.databinding.ActivitySecondBinding
import org.parceler.Parcels

class SecondActivity : AppCompatActivity() {
    private val binding: ActivitySecondBinding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = Parcels.unwrap<Cliente?>(intent.getParcelableExtra("client"))
        fillActivityMessage(client)
        binding.searchClientNameBtn.setOnClickListener {
            val intent: Intent?
            intent = Intent(Intent.ACTION_SEARCH)
                .putExtra(SearchManager.QUERY, client.name)
            openIntent(intent)
        }

        binding.searchClientAddressBtn.setOnClickListener {
            val uri: Uri?
            val intent: Intent?
            uri = Uri.parse("geo:0,0?q=${client.address}")
            intent = Intent(Intent.ACTION_VIEW, uri)
            openIntent(intent)
        }

        binding.callClientPhoneBtn.setOnClickListener {
            val uri: Uri?
            val intent: Intent?

            uri = Uri.parse("tel:"+client.phoneNumber)
            intent = Intent(Intent.ACTION_DIAL, uri)
            openIntent(intent)
        }
    }


    private fun openIntent(intent: Intent) {
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, R.string.error_intent, Toast.LENGTH_SHORT).show()
        }
    }


    private fun fillActivityMessage(client: Cliente?){
        client?.let {
            val text = resources.getString(R.string.second_activity_message_text,it.name, it.phoneNumber, it.address)
            binding.tvMessage.text = text
        }
    }


}