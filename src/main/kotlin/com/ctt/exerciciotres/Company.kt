package com.ctt.exerciciotres

class Company {
    val employeesList = ArrayList<Employee>()

    fun saveEmployee(employee: Employee): Boolean{
        val index = employeesList.indexOfFirst { it.id == employee.id }
        if (index != -1) return false
        employeesList.add(employee)
        return true
    }

    fun getEmployeeById(id:Int): Employee?{
      return  employeesList.firstOrNull { it.id == id}
    }

}