package com.example.dc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.widget.Button

class HistoryActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)


        val fab: View = findViewById(R.id.fabbtn2)
        fab.setOnClickListener {
            finish()
        }
    }

    //val diceHistory : <ArrayList<String>> =intent.getParcelableExtra("diceList");



}