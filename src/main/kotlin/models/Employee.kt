package models

import utils.Utils

class Employee(
    var firstName: String,
    var surName: String,
    var gender: Char,
    var grossSalary: Double,
    var payePercentage: Double,
    var prsiPercentage: Double,
    var annualBonus: Double,
    var cycleToWorkDeduction: Double
) {

    var employeeId: Int = -999

    private val utils = Utils()
    private fun getFullNameAndTitle(): String {
        var title = ""

        if (gender.compareTo('m') == 0) {
            title = "Mr."
        } else if (gender.compareTo('f') == 0) {
            title = "Ms."
        }
        return "$title $firstName $surName"

    }

    fun getMonthlySalary(): Double {
        return grossSalary / 12
    }

    private fun getMonthlyPRSI(): Double {
        return getMonthlySalary() * (prsiPercentage / 100)
    }

    private fun getMonthlyPAYE(): Double {
        return getMonthlySalary() * (payePercentage / 100)
    }

    private fun getMonthlyBonus(): Double {
        return annualBonus / 12
    }

    private fun getGrossMonthlyPay(): Double {
        return getMonthlySalary() + getMonthlyBonus()
    }

    private fun getTotalMonthlyDeductions(): Double {
        return getMonthlyPRSI() + getMonthlyPAYE() + (cycleToWorkDeduction / 12)
    }

    private fun getNetMonthlyPay(): Double {
        return getGrossMonthlyPay() - getTotalMonthlyDeductions()
    }

    fun getPayslip() =
        """
        ______________________________________________________________________
         Monthly Payslip:             ${getFullNameAndTitle()}, ID: $employeeId                 
        ______________________________________________________________________    
              PAYMENT DETAILS (gross pay: ${utils.formatToTwoDecimals(getGrossMonthlyPay())})                                                                    
        ______________________________________________________________________
                   Salary: ${utils.formatToTwoDecimals(getMonthlySalary())}
                   Bonus:  ${utils.formatToTwoDecimals(getMonthlyBonus())}            
        ______________________________________________________________________
              DEDUCTION DETAILS (total Deductions: ${utils.formatToTwoDecimals(getTotalMonthlyDeductions())})      
        ______________________________________________________________________
                   PAYE: ${utils.formatToTwoDecimals(getMonthlyPAYE())}                
                   PRSI: ${utils.formatToTwoDecimals(getMonthlyPRSI())}  
                   Cycle To Work: ${utils.formatToTwoDecimals(cycleToWorkDeduction / 12)}        
        ______________________________________________________________________
             NET PAY: ${utils.formatToTwoDecimals(getNetMonthlyPay())} 
        ______________________________________________________________________"""

    override fun toString(): String {
        return """
              ----------------------------------------------
              Employee $employeeId :
              First Name: $firstName 
              Surname: $surName
              Gender: $gender 
              Employee Id: $employeeId 
              Gross Salary: $grossSalary 
              P.A.Y.E Percentage: $payePercentage 
              P.R.S.I Percentage: $prsiPercentage 
              Annual Bonus: $annualBonus 
              Cycle To Work Deduction: $cycleToWorkDeduction
              ----------------------------------------------
        """.trimIndent()
    }
}