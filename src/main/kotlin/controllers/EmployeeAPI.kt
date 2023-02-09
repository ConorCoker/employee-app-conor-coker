package controllers

import models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeId == id }
    }

    fun create(employee: Employee) {
        employee.employeeId = getId()
        employees.add(employee)
    }

    fun delete(employee: Employee): Boolean {
        return employees.remove(employee)
    }

    fun update(
        employee: Employee,
        firstName: String,
        surName: String,
        gender: Char,
        grossSalary: Double,
        payePercentage: Double,
        prsiPercentage: Double,
        annualBonus: Double,
        cycleToWorkDeduction: Double
    ) {
        employee.firstName=firstName
        employee.surName=surName
        employee.gender=gender
        employee.grossSalary=grossSalary
        employee.payePercentage=payePercentage
        employee.prsiPercentage=prsiPercentage
        employee.annualBonus=annualBonus
        employee.cycleToWorkDeduction=cycleToWorkDeduction

    }

}
