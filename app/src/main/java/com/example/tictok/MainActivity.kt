package com.example.tictok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
    }

    fun btnSelect(view: android.view.View) {
        val btnchoise=view as Button
        var cellId=0
        when(btnchoise.id){
            R.id.btn1-> cellId=1
            R.id.btn2-> cellId=2
            R.id.btn3-> cellId=3
            R.id.btn4-> cellId=4
            R.id.btn5-> cellId=5
            R.id.btn6-> cellId=6
            R.id.btn7-> cellId=7
            R.id.btn8-> cellId=8
            R.id.btn9-> cellId=9
        }
        Log.d("cellID: ",cellId.toString())
        playgame(cellId,btnchoise)


    }


    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1


    fun playgame(cellid:Int , btnc:Button){
        if(activePlayer==1){
            btnc.setText("X")
            btnc.setBackgroundResource(R.color.blue)
            player1.add(cellid)
            activePlayer=2
            Autoplay()
        }
        else{

            btnc.setText("O")
            btnc.setBackgroundResource(R.color.Red)
            player2.add(cellid)
            activePlayer=1
        }
        btnc.isEnabled=false

        CheckWin()


    }





    fun CheckWin() {
        var win=-1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            win=1
        }
        else if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            win=2
        }
        else if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            win=1
        }
        else if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            win=2
        }
        else if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            win=1
        }
        else if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            win=2
        }
        else if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            win=1
        }
        else if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            win=2
        }else if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            win=1
        }
        else if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            win=2
        }else if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            win=1
        }
        else if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            win=2
        }else if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            win=1
        }
        else if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            win=2
        }else if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            win=1
        }
        else if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            win=2
        }


        if(win!=-1){
            Toast.makeText(this,"Player "+win+" win the game",Toast.LENGTH_LONG).show()
        }

    }

    fun Autoplay() {

        var emtycells=ArrayList<Int>()
        for (cellid in 1..9){
            if(!(player1.contains(cellid) || player2.contains(cellid))){
                emtycells.add(cellid)
            }
        }
        if(emtycells.size!=0){
            var r = Random
            var randIndex = r.nextInt(emtycells.size - 0) + 0
            var cellid = emtycells[randIndex]

            var btnsel: Button
            when (cellid) {
                1 -> btnsel = btn1
                2 -> btnsel = btn2
                3 -> btnsel = btn3
                4 -> btnsel = btn4
                5 -> btnsel = btn5
                6 -> btnsel = btn6
                7 -> btnsel = btn7
                8 -> btnsel = btn8
                9 -> btnsel = btn9
                else -> btnsel = btn1

            }
            playgame(cellid, btnsel)
        }
    }
}


