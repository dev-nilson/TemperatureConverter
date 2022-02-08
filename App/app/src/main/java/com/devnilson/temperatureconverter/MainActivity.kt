package com.devnilson.temperatureconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var degreesToConvertEditText: EditText
    private lateinit var conversionUnitRadioGroup: RadioGroup
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        degreesToConvertEditText = findViewById(R.id.degrees_edit_text)
        resultTextView = findViewById(R.id.result_text_view)
        conversionUnitRadioGroup = findViewById(R.id.temperature_unit_radio_group)
    }

    fun calculateClick(view: View) {
        val degreesToConvert = degreesToConvertEditText.text.toString()
        val degrees = degreesToConvert.toIntOrNull() ?: 0
        val toFahrenheit = when (conversionUnitRadioGroup.checkedRadioButtonId) {
            R.id.celcius_radio_button -> true
            else -> false
        }

        val conversion = TemperatureConverter(degrees, toFahrenheit)
        val result = conversion.result

        val resultText = getString(R.string.result, result)

        //  Check if EditView is empty to display a toast error message
        //  (no invalid data type can be entered since EditView accepts numbers only)
        if (degreesToConvert.isNullOrEmpty()) {
            resultTextView.text = "Enter a number"
        }
        else {
            if (toFahrenheit) {
                resultTextView.text = resultText + "F"
            }
            else {
                resultTextView.text = resultText + "C"
            }
        }
    }
}