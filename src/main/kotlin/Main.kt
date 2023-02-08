import models.Employee
import controllers.EmployeeAPI
import mu.KotlinLogging
import utils.Utils
import java.lang.NumberFormatException
import java.util.Scanner

val sc = Scanner(System.`in`)
val util = Utils()

var employees = EmployeeAPI()

val logger = KotlinLogging.logger {}


fun main(args: Array<String>) {
    logger.info { "Launching Models.Employee App" }
    start()
}


fun menu(): Int {

    do {
        try {
            print(
                """ 
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for Employee
         |   5. Update Employee Details
         |   6. Delete an Employee
         |   7. Sort Employees By Gross Salary (lowest to highest)
         |  -1. Exit
         |       
         |Enter Option : """.trimMargin()
            )
            return readln().toInt()
        } catch (e: NumberFormatException) {
            System.err.println("Invalid value received - Please try again: ")
        }

    } while (true)


}


fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5 -> updateEmployee()
            6 -> deleteEmployee()
            7 -> sortEmployeesBySalary()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun sortEmployeesBySalary() {
    TODO("Not yet implemented")
}

fun deleteEmployee() {
    TODO("Not yet implemented")
}

fun updateEmployee() {
    TODO("Not yet implemented")
}

fun list() {
    logger.info { println("Calling findAll() and using lambda to print each employee") }
    employees.findAll().forEach { println(it) }
}

fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}

internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readln().toInt()
    return employees.findOne(employeeID)
}

fun paySlip() {
    logger.info { println("Calling getEmployeeById()") }
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}

fun dummyData() {
//    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
//    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
//    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}

fun add() {

    employees.create(
        Employee(
            util.displayPromptReadString("Enter first name: "),
            util.displayPromptReadString("Enter surname: "),
            util.displayPromptReadChar("Enter gender (m/f): "),
            util.displayPromptReadDouble("Enter gross salary: "),
            util.displayPromptReadDouble("Enter PAYE %: "),
            util.displayPromptReadDouble("Enter PRSI %: "),
            util.displayPromptReadDouble("Enter Annual Bonus: "),
            util.displayPromptReadDouble("Enter Cycle to Work Deduction: ")
        )
    )


}










