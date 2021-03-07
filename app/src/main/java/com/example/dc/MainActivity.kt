package com.example.dc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val TAG: String="xyz"
    private val mRandomGenerator = Random()
    private var numberOfDice: Int = 6
    private val diceImageId = intArrayOf(0, R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)

    private val mHistory = mutableListOf<Array<Int>>()
    private val initArray = arrayOf(1,2,3,4,5,6)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRoll.setOnClickListener { v -> onRoll() }
        NumberPicker.minValue = 1
        NumberPicker.maxValue = 6
        NumberPicker.setValue(6)
        NumberPicker.setOnValueChangedListener{picker, oldVal,newVal -> numberOfDice = newVal; addDice(initArray)}
        Log.d(TAG, "OnCreate")
        val clear = intent.getIntExtra("clear", 0)
        if(clear == 1){
            mHistory.clear()
        }

        val button = findViewById<Button>(R.id.btnHistory)
        button.setOnClickListener {
            openSecondPage()
        }
    }

    fun addDice(diceResults: Array<Int>){
        if(numberOfDice == 1){
            imgDice1.visibility = View.VISIBLE
            imgDice1.setImageResource(diceImageId[diceResults[0]])
            imgDice2.visibility = View.INVISIBLE
            imgDice3.visibility = View.INVISIBLE
            imgDice4.visibility = View.INVISIBLE
            imgDice5.visibility = View.INVISIBLE
            imgDice6.visibility = View.INVISIBLE
        }
        if(numberOfDice == 2){
            imgDice1.visibility = View.VISIBLE
            imgDice1.setImageResource(diceImageId[diceResults[0]])
            imgDice2.visibility = View.VISIBLE
            imgDice2.setImageResource(diceImageId[diceResults[1]])
            imgDice3.visibility = View.INVISIBLE
            imgDice4.visibility = View.INVISIBLE
            imgDice5.visibility = View.INVISIBLE
            imgDice6.visibility = View.INVISIBLE
        }
        if(numberOfDice == 3){
            imgDice1.visibility = View.VISIBLE
            imgDice1.setImageResource(diceImageId[diceResults[0]])
            imgDice2.visibility = View.VISIBLE
            imgDice2.setImageResource(diceImageId[diceResults[1]])
            imgDice3.visibility = View.VISIBLE
            imgDice3.setImageResource(diceImageId[diceResults[2]])
            imgDice4.visibility = View.INVISIBLE
            imgDice5.visibility = View.INVISIBLE
            imgDice6.visibility = View.INVISIBLE
        }
        if(numberOfDice == 4){
            imgDice1.visibility = View.VISIBLE
            imgDice1.setImageResource(diceImageId[diceResults[0]])
            imgDice2.visibility = View.VISIBLE
            imgDice2.setImageResource(diceImageId[diceResults[1]])
            imgDice3.visibility = View.VISIBLE
            imgDice3.setImageResource(diceImageId[diceResults[2]])
            imgDice4.visibility = View.VISIBLE
            imgDice4.setImageResource(diceImageId[diceResults[3]])
            imgDice5.visibility = View.INVISIBLE
            imgDice6.visibility = View.INVISIBLE
        }
        if(numberOfDice == 5){
            imgDice1.visibility = View.VISIBLE
            imgDice1.setImageResource(diceImageId[diceResults[0]])
            imgDice2.visibility = View.VISIBLE
            imgDice2.setImageResource(diceImageId[diceResults[1]])
            imgDice3.visibility = View.VISIBLE
            imgDice3.setImageResource(diceImageId[diceResults[2]])
            imgDice4.visibility = View.VISIBLE
            imgDice4.setImageResource(diceImageId[diceResults[3]])
            imgDice5.visibility = View.VISIBLE
            imgDice5.setImageResource(diceImageId[diceResults[4]])
            imgDice6.visibility = View.INVISIBLE
        }
        if(numberOfDice == 6){
            imgDice1.visibility = View.VISIBLE
            imgDice1.setImageResource(diceImageId[diceResults[0]])
            imgDice2.visibility = View.VISIBLE
            imgDice2.setImageResource(diceImageId[diceResults[1]])
            imgDice3.visibility = View.VISIBLE
            imgDice3.setImageResource(diceImageId[diceResults[2]])
            imgDice4.visibility = View.VISIBLE
            imgDice4.setImageResource(diceImageId[diceResults[3]])
            imgDice5.visibility = View.VISIBLE
            imgDice5.setImageResource(diceImageId[diceResults[4]])
            imgDice6.visibility = View.VISIBLE
            imgDice6.setImageResource(diceImageId[diceResults[5]])
        }
    }

    fun onRoll() {
        var dice = Array(numberOfDice) {i -> mRandomGenerator.nextInt(6) + 1}
        addDice(dice)
        updateHistory(dice)
    }

    private fun updateHistory(diceResults: Array<Int>) {
        mHistory.add(diceResults)
    }

    override fun onSaveInstanceState(outState: Bundle){
       super.onSaveInstanceState(outState)
        Log.d(TAG, "History saved")
    }

    private fun openSecondPage(){
            var translatedList = ArrayList<String>()
            for (list in mHistory) {
                var s = ""
                list.forEach { p ->
                    s += "$p "
                }
                translatedList.add(s)
            }
                Intent(this, HistoryActivity::class.java).also {
                it.putStringArrayListExtra("dice", translatedList)
                startActivity(it)
            }
        }
}