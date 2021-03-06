package com.example.dc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView

class HistoryActivity : AppCompatActivity()  {

    val translatedList = intent?.getStringArrayListExtra("diceList")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val listView = findViewById<ListView>(R.id.list)

        val fab: View = findViewById(R.id.fabbtn2)
        fab.setOnClickListener {
            finish()
        }
    }

    //val diceHistory : <ArrayList<String>> =intent.getParcelableExtra("diceList");



}