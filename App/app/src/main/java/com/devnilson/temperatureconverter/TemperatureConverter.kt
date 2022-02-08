package com.devnilson.temperatureconverter

class TemperatureConverter(var degreesToConvert: Float, var toFahrenheit: Boolean) {
    val result: Double
        get() {
            if (toFahrenheit) {
                return (degreesToConvert * 1.8) + 32;
            }

            return (degreesToConvert - 32) * .5556
        }
}