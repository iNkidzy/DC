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
import kotlin.collections.ArrayList

class HistoryActivity : AppCompatActivity()  {

    val translatedList = intent.getStringArrayListExtra("diceList")!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val listView = findViewById<ListView>(R.id.list)

      val arrayList = ArrayList<String>()
        arrayList.add("Dice 1")
        arrayList.add("Dice 2")
        arrayList.add("Dice 3")
        arrayList.add("Dice 4")
        arrayList.add("Dice 5")
        arrayList.add("Dice 6")
        arrayList.add("HEY")
        arrayList.add("Buddy")
        arrayList.add("We DID IT")

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,translatedList)
        listView.adapter = arrayAdapter



        val fab: View = findViewById(R.id.fabbtn2)
        fab.setOnClickListener {
            finish()
        }
    }

    //val diceHistory : <ArrayList<String>> =intent.getParcelableExtra("diceList");



}