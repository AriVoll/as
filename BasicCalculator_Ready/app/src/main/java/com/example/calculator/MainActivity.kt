package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var result: EditText
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)

        // Общий обработчик для всех кнопок цифр
        val numbers = arrayOf(
            R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4,
            R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9
        )

        for (id in numbers) {
            findViewById<Button>(id).setOnClickListener {
                result.append((it as Button).text)
            }
        }

        // Кнопка десятичной запятой.
        // Вторую запятую в одном числе добавить нельзя.
        findViewById<Button>(R.id.bComma).setOnClickListener {
            if (!result.text.contains(",")) {
                if (result.text.isEmpty()) {
                    result.setText("0,")
                    result.setSelection(result.length())
                } else {
                    result.append(",")
                }
            }
        }

        findViewById<Button>(R.id.bPlus).setOnClickListener { operation("+") }
        findViewById<Button>(R.id.bMinus).setOnClickListener { operation("-") }
        findViewById<Button>(R.id.bMultiply).setOnClickListener { operation("*") }
        findViewById<Button>(R.id.bDivide).setOnClickListener { operation("/") }

        findViewById<Button>(R.id.bEquals).setOnClickListener {
            calculate()
        }
    }

    private fun operation(op: String) {
        if (result.text.isNotEmpty()) {
            tv1.text = result.text
            tv2.text = op
            result.text.clear()
        }
    }

    private fun calculate() {
        if (tv1.text.isEmpty() || tv2.text.isEmpty() || result.text.isEmpty()) {
            return
        }

        val number1 = tv1.text.toString().replace(',', '.').toDouble()
        val number2 = result.text.toString().replace(',', '.').toDouble()
        val operation = tv2.text.toString()

        val answer = when (operation) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> {
                if (number2 == 0.0) {
                    result.setText("Ошибка")
                    tv1.text = ""
                    tv2.text = ""
                    return
                }
                number1 / number2
            }
            else -> return
        }

        // Показываем результат и очищаем два TextView
        result.setText(answer.toString())
        tv1.text = ""
        tv2.text = ""
    }
}
