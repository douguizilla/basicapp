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
        createListView(this, client)
    }

    private fun openIntentAtPosition(position: Int, client: Cliente) {
        val uri: Uri?
        val intent: Intent?
        when(position){
            0 -> {
                intent = Intent(Intent.ACTION_SEARCH)
                    .putExtra(SearchManager.QUERY, client.name)
                openIntent(intent)
            }
            1 -> {
                uri = Uri.parse("tel:"+client.phoneNumber)
                intent = Intent(Intent.ACTION_DIAL, uri)
                openIntent(intent)
            }
            2 -> {
                uri = Uri.parse("geo:0,0?q=${client.address}")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            else -> finish()
        }
    }

    private fun openIntent(intent: Intent) {
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, R.string.error_intent, Toast.LENGTH_SHORT).show()
        }
    }

    private fun createListView(context: Context, client : Cliente){
        val listView = ListView(context)
        setContentView(listView)
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.intent_actions))
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            openIntentAtPosition(position,client)
        }
    }

    private fun fillActivityMessage(client: Cliente?){
        client?.let {
            val text = resources.getString(R.string.second_activity_message_text,it.name, it.phoneNumber, it.address)
            binding.tvMessage.text = text
        }
    }


}