package com.ctt.exerciciotres

interface Employee {
    val id: Int
    val name: String
    val cpf: String
    var currentWage: Double

    fun employeeType(): String
    fun toIncreaseSalary()
}