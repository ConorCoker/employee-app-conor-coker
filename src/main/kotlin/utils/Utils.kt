package utils

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

class Utils {

    val sc = Scanner(System.`in`)
    fun formatToTwoDecimals(doubleToFormat: Double): String {

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(doubleToFormat)
    }

    fun displayPromptReadString(prompt: String): String {
        print(prompt)
        return sc.next()
    }

    fun displayPromptReadChar(prompt: String): Char {
        do {
            print(prompt)
            val charToReturn = sc.next().lowercase().toCharArray()[0]
            if (charToReturn == 'm' || charToReturn == 'f') {
                return charToReturn
            }
            else{
                System.err.print("Gender must be 'm' or 'f': ")
            }
        } while (true) //the code above I came up with but I got the while (true) from an example from last year
    }    //so I will ask how this works in the interview.


    fun displayPromptReadDouble(prompt: String): Double {
        do {
            try {
                print(prompt)
                return sc.next().toDouble()
            } catch (e: NumberFormatException) {
                System.err.print("Please enter a valid value!")
            }
        } while (true)
    }
}