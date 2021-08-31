package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TextView
        val input = binding.input

        //Special Buttons
        val ac = binding.btnAc
        val point = binding.btnPoint
        val equals = binding.btnEquals

        //Operators
        val divide = binding.btnDivide
        val plus = binding.btnPlus
        val times = binding.btnTimes
        val minus = binding.btnMinus

        //Operators
        val zero = binding.btnZero
        val one = binding.btnOne
        val two = binding.btnTwo
        val three = binding.btnThree
        val four = binding.btnFour
        val five = binding.btnFive
        val six = binding.btnSix
        val seven = binding.btnSeven
        val eight = binding.btnEight
        val nine = binding.btnNine

        //Others
        var state = "empty"
        val calculation = mutableListOf<String>()
        val displayable = mutableListOf<String>()
        var characters = 0
        var operator = ""

        //OnClickListener - Special Buttons
        equals.setOnClickListener {
            when(state) {
                "num2" -> {
                    val calculate = calculate(operator, calculation)
                    input.text = calculate.toString()
                    state = "num1"
                    operator = ""
                    characters = 0
                    displayable.clear()
                    calculation.clear()
                    displayable.add(calculate.toString())
                    calculation.add(calculate.toString())
                }
            }
        }

        ac.setOnClickListener {
            state = "empty"
            characters = 0
            displayable.clear()
            calculation.clear()
            operator = ""
            update(displayable, input)
        }


        point.setOnClickListener {
            if (characterLimit(characters)) {
                when(state) {
                    "num1"-> {
                        calculation.add(".")
                        displayable.add(".")
                        characters += 1
                        update(displayable, input)
                    }
                    "num2" -> {
                        calculation.add(".")
                        displayable.add(".")
                        characters += 1
                        update(displayable, input)
                    }
                }
            }

        }

        //Operators
        plus.setOnClickListener {
            if (characterLimit(characters)) {
                when(state) {
                    "num1" -> {
                        calculation.add("+")
                        displayable.add("+")
                        state = "operator"
                        operator = "+"
                        characters += 1
                        update(displayable, input)
                    }
                    "num1 percentage" -> {
                        calculation.add("+")
                        displayable.add("+")
                        state = "operator"
                        operator = "+"
                        characters += 1
                        update(displayable, input)
                    }
                }
            }
        }

        times.setOnClickListener {
            if (characterLimit(characters)) {
                when(state) {
                    "num1" -> {
                        calculation.add("*")
                        displayable.add("x")
                        state = "operator"
                        operator = "*"
                        characters += 1
                        update(displayable, input)
                    }
                    "num1 percentage" -> {
                        calculation.add("+")
                        displayable.add("+")
                        state = "operator"
                        operator = "*"
                        characters += 1
                        update(displayable, input)
                    }
                }
            }
        }

        divide.setOnClickListener {
            if (characterLimit(characters)) {
                when(state) {
                    "num1" -> {
                        calculation.add("/")
                        displayable.add("÷")
                        state = "operator"
                        operator = "/"
                        characters += 1
                        update(displayable, input)
                    }
                    "num1 percentage" -> {
                        calculation.add("+")
                        displayable.add("+")
                        state = "operator"
                        characters += 1
                        operator = "/"
                        update(displayable, input)
                    }
                }
            }
        }

        minus.setOnClickListener {
            if (characterLimit(characters)) {
                when(state) {
                    "num1" -> {
                        calculation.add("-")
                        displayable.add("-")
                        state = "operator"
                        operator = "-"
                        characters += 1
                        update(displayable, input)
                    }
                    "num1 percentage" -> {
                        calculation.add("+")
                        displayable.add("+")
                        state = "operator"
                        operator = "-"
                        characters += 1
                        update(displayable, input)
                    }
                }
            }
        }

        //Numbers
        zero.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("0")
                    displayable.add("0")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        one.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("1")
                    displayable.add("1")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        two.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("2")
                    displayable.add("2")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        three.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("3")
                    displayable.add("3")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        four.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("4")
                    displayable.add("4")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        five.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("5")
                    displayable.add("5")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        six.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("6")
                    displayable.add("6")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        seven.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("7")
                    displayable.add("7")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        eight.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("8")
                    displayable.add("8")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }
            }
        }

        nine.setOnClickListener {
            if (characterLimit(characters)) {
                if (state != "num1 percentage" && state != "num2 percentage") {
                    calculation.add("9")
                    displayable.add("9")
                    characters += 1
                    when(state) {
                        "empty" -> state = "num1"
                        "operator" -> state = "num2"
                        "num1 neg" -> state = "num1"
                        "num2 neg" -> state = "num2"
                    }
                    update(displayable, input)
                }

            }
        }

    }

    //Update textview
    private fun update(displayable: List<String>, input: TextView) {
        input.text = displayable.joinToString(separator = "")
    }

    //Check character limit
    private fun characterLimit(characters: Int): Boolean {
        return characters < 15
    }

    //To calculate complete calculation
    private fun calculate(operator: String, calculation: MutableList<String>): Int {
        calculation.joinToString().split(operator)
        calculation.removeAt(1)
        var answer = 0
        when(operator) {
            "+" -> {
                answer = (calculation[0].toFloat() + calculation[1].toFloat()).roundToInt()
            }
            "*" -> {
                answer = (calculation[0].toFloat() * calculation[1].toFloat()).roundToInt()
            }
            "-" -> {
                answer = (calculation[0].toFloat() - calculation[1].toFloat()).roundToInt()
            }
            "/" -> {
                answer = (calculation[0].toFloat() / calculation[1].toFloat()).roundToInt()
            }
        }

        return answer
    }


}