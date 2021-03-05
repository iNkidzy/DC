package com.example.dc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.NumberPicker;

class MainActivity : AppCompatActivity() {
    private val HISTORY_NAME ="history"
    private val TAG: String="xyz"
    private val mRandomGenerator = Random()
    private var numberOfDice: Int = 1;
    private val diceImageId = intArrayOf(0, R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)

    private val mHistory = mutableListOf<Pair<Int, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRoll.setOnClickListener { v -> onRoll() }
        NumberPicker.minValue = 1
        NumberPicker.maxValue = 6
        NumberPicker.setOnValueChangedListener{picker, oldVal,newVal -> numberOfDice = newVal; addDice()}
        Log.d(TAG, "OnCreate")

    }

    fun addDice(){
        //first remove all dice
        var dice = Array(numberOfDice) {i -> mRandomGenerator.nextInt(6) + 1}
        dice.forEach {
            var newView: ImageView
            newView = ImageView(this)
            //add new imageview to main page
            //set dimensions of dice and somehow make them not collide
            newView.setImageResource( diceImageId[it])}
    }

    fun onRoll() {
        //check each die and roll it
    }

    private fun updateHistory() {

    }
    override fun onSaveInstanceState(outState: Bundle){
       super.onSaveInstanceState(outState)
        Log.d(TAG, "History saved")

    }
    fun onClear() {
    }

    fun onRoll(view: View) {

    }
    fun onHistory(view: View) {

    }
}