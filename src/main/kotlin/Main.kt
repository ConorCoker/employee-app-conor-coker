import java.math.RoundingMode
import java.text.DecimalFormat

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
    val netPay = (grossPay-totalDeductions)

    return ("""
                ------------------------------------------------------------------
                |                        Monthly Payslip                         |
                ------------------------------------------------------------------
                |                                                                |
                | Employee Name: ${firstName.uppercase()} ${surName.uppercase()} ($gender)  Employee ID: $employeeId  |
                |                                                                |
                |                                                                |
                -----------------------------------------------------------------|                                                     
                |  Payment Details              Deduction Details                |
                -----------------------------------------------------------------|                                     
                |   Salary:${df.format(monthlySalary)}           PAYE:${df.format(monthlyPaye)}      |  
                |   Bonus:${df.format(monthlyBonus)}             PRSI:${df.format(monthlyPrsi)}          |  
                |                                     Cycle to work:$cycleToWorkDeduction|
                |                                                                |                                                                      
                ------------------------------------------------------------------
                |  Gross:${df.format(grossPay)}                    Total Deductions:${df.format(totalDeductions)}                |
                ------------------------------------------------------------------
                |                NET PAY:${df.format(netPay)}                                  |
                ------------------------------------------------------------------
                ==>>  """)
}