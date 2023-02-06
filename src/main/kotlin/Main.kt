val utils = Utils()

val joe = Employee(
    "Joe", "Soap", 'm', 6143, 67543.21, 38.5,
    5.2, 1450.50, 54.33
)

fun main(args: Array<String>) {

    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> println("Monthly Salary: ${utils.formatToTwoDecimals(joe.getMonthlySalary())}")
            2 -> println("Monthly PRSI: ${utils.formatToTwoDecimals(joe.getMonthlyPRSI())}")
            3 -> println("Monthly PAYE: ${utils.formatToTwoDecimals(joe.getMonthlyPAYE())}")
            4 -> println("Monthly Gross Pay: ${utils.formatToTwoDecimals(joe.getGrossMonthlyPay())}")
            5 -> println("Monthly Total Deductions: ${utils.formatToTwoDecimals(joe.getTotalMonthlyDeductions())}")
            6 -> println("Monthly Net Pay: ${utils.formatToTwoDecimals(joe.getNetMonthlyPay())}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
    } while (input != -1)
}

fun menu(): Int {
    print(
        """
         Employee Menu for ${joe.getFullNameAndTitle()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """
    )
    return readln().toInt()
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




