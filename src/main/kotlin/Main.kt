import java.math.RoundingMode
import java.text.DecimalFormat

val df = DecimalFormat("#.##")

fun main(args: Array<String>) {


    println("Pay Slip Printer")
    println(printPayslip())
}

val firstName = "Joe"
val surName = "Soap"
val gender = 'm'
val employeeId = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkDeduction = 54.33

fun printPayslip(): String {

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING

    val monthlySalary = (grossSalary / 12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val monthlyBonus = (annualBonus / 12)
    val grossPay = (monthlySalary + (annualBonus / 12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkDeduction)
    val netPay = (grossPay - totalDeductions)

    return ("""
                ------------------------------------------------------------------
                |                        Monthly Payslip                         |
                ------------------------------------------------------------------
                |                                                                |
                | Employee Name: ${getFullNameAndTitle()}                        |
                |                                                                |
                |                                                                |
                -----------------------------------------------------------------|                                                     
                |  Payment Details              Deduction Details                |
                -----------------------------------------------------------------|                                     
                |   Salary:${formatToTwoDecimals(monthlySalary)}           PAYE:${formatToTwoDecimals(monthlyPaye)}      |  
                |   Bonus:${formatToTwoDecimals(monthlyBonus)}             PRSI:${formatToTwoDecimals(monthlyPrsi)}          |  
                |                                     Cycle to work:$cycleToWorkDeduction|
                |                                                                |                                                                      
                ------------------------------------------------------------------
                |  Gross:${formatToTwoDecimals(grossPay)}                    Total Deductions:${formatToTwoDecimals(totalDeductions)}                |
                ------------------------------------------------------------------
                |                NET PAY:${formatToTwoDecimals(netPay)}                                  |
                ------------------------------------------------------------------
                ==>>  """)
}

fun formatToTwoDecimals(doubleToFormat: Double): String {
    df.roundingMode = RoundingMode.CEILING
    return df.format(doubleToFormat)
}

fun getFullNameAndTitle(): String {
    var title = ""

    if (gender.compareTo('m') == 0) {
        title = "Mr."
    } else if (gender.compareTo('f') == 0) {
        title = "Ms."
    }
    return "$title $firstName $surName"

}
