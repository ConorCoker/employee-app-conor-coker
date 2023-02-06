class Employee(
    val firstName: String,
    val surName: String,
    val gender: Char,
    val employeeId: Int,
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
}