package models

import utils

class Employee(
    val firstName: String,
    val surName: String,
    val gender: Char,
    var employeeId: Int,
    val grossSalary: Double,
    val payePercentage: Double,
    val prsiPercentage: Double,
    val annualBonus: Double,
    val cycleToWorkDeduction: Double
) {
    fun getFullNameAndTitle(): String {
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

    fun getMonthlyPRSI(): Double {
        return getMonthlySalary() * (prsiPercentage / 100)
    }

    fun getMonthlyPAYE(): Double {
        return getMonthlySalary() * (payePercentage / 100)
    }

    fun getMonthlyBonus():Double{
        return annualBonus / 12
    }

    fun getGrossMonthlyPay(): Double {
        return getMonthlySalary() + getMonthlyBonus()
    }

    fun getTotalMonthlyDeductions():Double{
        return getMonthlyPRSI() + getMonthlyPAYE() + (cycleToWorkDeduction/12)
    }

    fun getNetMonthlyPay():Double{
        return getGrossMonthlyPay()-getTotalMonthlyDeductions()
    }

    fun getPayslip() =
        """
        ______________________________________________________________________
         Monthly Payslip:             ${getFullNameAndTitle()}, ID: ${employeeId}                 
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
                   Cycle To Work: ${utils.formatToTwoDecimals(cycleToWorkDeduction/12)}        
        ______________________________________________________________________
             NET PAY: ${utils.formatToTwoDecimals(getNetMonthlyPay())} 
        ______________________________________________________________________"""

    override fun toString(): String {
        return "Models.Employee(firstName='$firstName', surName='$surName', gender=$gender, employeeId=$employeeId, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkDeduction=$cycleToWorkDeduction)"
    }
}