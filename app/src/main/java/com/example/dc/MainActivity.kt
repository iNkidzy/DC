package com.example.dc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private val HISTORY_NAME ="history"
    private val TAG: String="xyz"


    val diceIds= arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
        R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)
    val mRandomGenerator = Random()
    val mHistory = mutableListOf<Pair<Int,Int>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRoll.setOnClickListener { v -> onRoll() }

        imgDice1.setOnClickListener { v -> onRoll() }
        imgDice2.setOnClickListener { v -> onRoll() }
        btnClear.setOnClickListener { v -> onClear() }
        Log.d(TAG, "OnCreate")

        if(savedInstanceState != null)
        {

            val history = savedInstanceState.getSerializable(HISTORY_NAME) as Array<Pair<Int,Int>>
            history.forEach{p->mHistory.add(p)}
            updateHistory()
            if(mHistory.size>0){
                updateDiceWith(mHistory[mHistory.size-1])
            }
        }
    }



    fun onRoll() {
        val d1 = mRandomGenerator.nextInt(6)+1
        val d2 = mRandomGenerator.nextInt(6)+1


        imgDice1.setImageResource(diceIds[d1])
        imgDice2.setImageResource(diceIds[d2])

        mHistory.add(Pair(e1,e2))
        if (mHistory.size > 5) mHistory.removeAt(0)
        updateHistory()
        Log.d(TAG, "Roll")

    }

    private fun updateHistory() {
        var s = ""
        mHistory.forEach{p-> val e1= p.first; val e2= p.second
                    s += "$e1-$e2\n"}
         tvHistory.text = s


    }
    override fun onSaveInstanceState(outState: Bundle){
       super.onSaveInstanceState(outState)
        Log.d(TAG, "History saved")
        outState.putSerializable(HISTORY_NAME, mHistory.toTypedArray())

    }
    fun onClear() {
        mHistory.clear()
        updateHistory()
    }

    fun onRoll(view: View) {

    }
    fun onHistory(view: View) {

    }
}