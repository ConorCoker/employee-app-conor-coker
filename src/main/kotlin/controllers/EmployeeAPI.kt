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

    fun sortBySalary() {
        for (i in 0 until employees.size) {
            for (j in i + 1 until employees.size) {
                if (employees[i].getMonthlySalary() > employees[j].getMonthlySalary()) {
                    swap(employees[i], employees[j])
                }
            }
        }
    }

    private fun swap(firstEmployee: Employee, secondEmployee: Employee) {
        val tempEmployee = employees[employees.indexOf(secondEmployee)]
        val indexOfFirstEmployee = employees.indexOf(firstEmployee)
        employees[employees.indexOf(secondEmployee)] = firstEmployee
        employees[indexOfFirstEmployee] = tempEmployee
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
        employee.firstName = firstName
        employee.surName = surName
        employee.gender = gender
        employee.grossSalary = grossSalary
        employee.payePercentage = payePercentage
        employee.prsiPercentage = prsiPercentage
        employee.annualBonus = annualBonus
        employee.cycleToWorkDeduction = cycleToWorkDeduction

    }

}
