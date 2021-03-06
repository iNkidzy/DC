package com.example.dc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.*

class HistoryActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val translatedList = intent.getStringArrayListExtra("dice")!!
        val listView = findViewById<ListView>(R.id.list)
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,translatedList)
        listView.adapter = arrayAdapter

        val fab: View = findViewById(R.id.fabbtn2)
        fab.setOnClickListener {
            finish()
        }

        val fab2: View = findViewById(R.id.fabbtn)
        fab2.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                it.putExtra("clear", 1)
                startActivity(it)
            }
            finish()
        }
    }
}