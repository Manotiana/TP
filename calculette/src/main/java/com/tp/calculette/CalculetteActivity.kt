package com.tp.calculette

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import com.tp.calculette.databinding.ActivityCalculetteBinding

class CalculetteActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculetteBinding
    var firstOperand: String = ""
    var  secondOperand: String = ""
     var lockFirstOperand : String =""



    lateinit var operation : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculetteBinding.inflate(LayoutInflater.from(baseContext))
        setContentView(binding.root)
        binding.one.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("1")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("1")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("1")
            }*/
            assignNumberToOperand("1")
        }
        binding.two.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("2")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("2")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("2")
            }*/
            assignNumberToOperand("2")

        }
        binding.three.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("3")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("3")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("3")
            }*/
            assignNumberToOperand("3")
        }
        binding.four.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("4")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("4")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("4")
            }*/
            assignNumberToOperand("4")
        }
        binding.five.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("5")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("5")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("5")
            }*/
            assignNumberToOperand("5")
        }
        binding.six.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("6")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("6")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("6")
            }*/
            assignNumberToOperand("6")
        }
        binding.seven.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("7")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("7")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("7")
            }*/
            assignNumberToOperand("7")
        }
        binding.eight.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("8")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("8")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("8")
            }*/
            assignNumberToOperand("8")
        }
        binding.nine.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("9")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("9")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("9")
            }*/
            assignNumberToOperand("9")
        }
        binding.zero.setOnClickListener(){
            //test the current operand
            //firstClick
            /*if(!this::lockFirstOperand.isInitialized){
                firstOperand = firstOperand.plus("0")
                val tv: TextView = findViewById(R.id.field1)
                tv.text = firstOperand
            }else{
                secondOperand = secondOperand.plus("0")
                val tv: TextView = findViewById(R.id.field1)
                val textCurrent = (tv.text).toString()
                tv.text = textCurrent.plus("0")
            }*/
            assignNumberToOperand("0")
        }

        binding.plus.setOnClickListener(){
            /*operation = "add"
            var firstOp : String = (binding.field1.text).toString()
            binding.field1.text = firstOp + " + "
            lockFirstOperand = "initialized"*/
            initializeOperationAndFirstOperand("add","+")
        }
        binding.minus.setOnClickListener(){
            /*operation ="minus"
            var firstOp : String = (binding.field1.text).toString()
            binding.field1.text = firstOp + " - "
            lockFirstOperand = "initialized"*/
            initializeOperationAndFirstOperand("minus","-")
        }
        binding.mul.setOnClickListener(){
            initializeOperationAndFirstOperand("mul","*")
        }
        binding.divide.setOnClickListener(){
            initializeOperationAndFirstOperand("divide","/")
        }
        binding.equal.setOnClickListener(){
            when (operation){
                "add" -> {
                    binding.field2.text = (firstOperand.toInt() + secondOperand.toInt()).toString()
                   reInitAfterEqual()
                }
                "minus" -> {
                    binding.field2.text = (firstOperand.toInt() - secondOperand.toInt()).toString()
                    reInitAfterEqual()
                }
                "mul" -> {
                    binding.field2.text = (firstOperand.toInt() * secondOperand.toInt()).toString()
                    reInitAfterEqual()
                }
                "divide" -> {
                    if(secondOperand.toFloat().equals(0.0f))
                        binding.field2.text ="div by zero not allowed!"
                    else
                        binding.field2.text = (firstOperand.toFloat().div(secondOperand.toFloat())).toString()

                    reInitAfterEqual()
                }
            }
        }
    }
    private fun assignNumberToOperand(buttonValue : String){
        if( lockFirstOperand.equals("")){
            firstOperand = firstOperand.plus(buttonValue)
            val tv: TextView = findViewById(R.id.field1)
            tv.text = firstOperand
        }else{
            secondOperand = secondOperand.plus(buttonValue)
            val tv: TextView = findViewById(R.id.field1)
            val textCurrent = (tv.text).toString()
            tv.text = textCurrent.plus(buttonValue)
        }
    }
    private fun initializeOperationAndFirstOperand(operation : String, symbol: String){
        this.operation = operation
        var firstOp : String = (binding.field1.text).toString()
        binding.field1.text = firstOp.plus(" ").plus(symbol).plus(" ")
        lockFirstOperand = "initialized"
    }
    private fun reInitAfterEqual(){
        binding.field1.text = ""
        lockFirstOperand =""
        firstOperand =""
        secondOperand =""
    }
}