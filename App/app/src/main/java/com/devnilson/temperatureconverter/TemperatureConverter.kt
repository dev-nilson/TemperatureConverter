package com.devnilson.temperatureconverter

class TemperatureConverter(var degreesToConvert: Int, var toFahrenheit: Boolean) {
    val result: String
        get() {
            if (toFahrenheit) {
                return "%.1f".format((degreesToConvert * 1.8) + 32)
            }

            return "%.1f".format((degreesToConvert - 32) * .5556)
        }
}