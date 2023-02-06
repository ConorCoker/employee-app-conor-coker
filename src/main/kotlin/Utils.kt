import java.math.RoundingMode
import java.text.DecimalFormat

class Utils {
    fun formatToTwoDecimals(doubleToFormat: Double): String {

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(doubleToFormat)
    }
}