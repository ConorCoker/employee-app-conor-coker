val utils = Utils()

val joe = Employee(
    "Joe", "Soap", 'm', 6143, 67543.21, 38.5,
    5.2, 1450.50, 54.33
)

fun main(args: Array<String>) {


    println(joe.getFullNameAndTitle())
    println("Monthly Salary: ${joe.getMonthlySalary()}")
    println("Monthly PRSI: ${joe.getMonthlyPRSI()}")
    println("Monthly PAYE: ${joe.getMonthlyPAYE()}")
    println("Monthly Gross Pay: ${joe.getGrossMonthlyPay()}")
    println("Monthly Total Deductions: ${joe.getTotalMonthlyDeductions()}")
    println("Monthly Net Pay: ${joe.getNetMonthlyPay()}")
    println(getPayslip())


}

fun getPayslip(): String {

    return """
                ------------------------------------------------------------------
                |                        Monthly Payslip                         |
                ------------------------------------------------------------------
                |                                                                |
                | Employee Name: ${joe.getFullNameAndTitle()}                        |
                |                                                                |
                |                                                                |
                -----------------------------------------------------------------|                                                     
                |  Payment Details              Deduction Details                |
                -----------------------------------------------------------------|                                     
                |   Salary:${utils.formatToTwoDecimals(joe.getMonthlySalary())}           PAYE:${
        utils.formatToTwoDecimals(
            joe.getMonthlyPAYE()
        )
    }      |  
                |   Bonus:${utils.formatToTwoDecimals(joe.getMonthlyBonus())}             PRSI:${
        utils.formatToTwoDecimals(
            joe.getMonthlyPRSI()
        )
    }          |  
                |                                     Cycle to work:${joe.cycleToWorkDeduction}|
                |                                                                |                                                                      
                ------------------------------------------------------------------
                |  Gross:${utils.formatToTwoDecimals(joe.getGrossMonthlyPay())}                    Total Deductions:${
        utils.formatToTwoDecimals(
            joe.getTotalMonthlyDeductions()
        )
    }                |
                ------------------------------------------------------------------
                |                NET PAY:${utils.formatToTwoDecimals(joe.getNetMonthlyPay())}                                  |
                ------------------------------------------------------------------
                ==>>  """


}




