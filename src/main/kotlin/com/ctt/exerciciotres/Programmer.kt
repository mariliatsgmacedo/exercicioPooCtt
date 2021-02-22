package com.ctt.exerciciotres

class Programmer(
    override val id: Int,
    override val name: String,
    override val cpf: String,
    override var currentWage: Double
) :Employee {
    override fun employeeType(): String {
        return "Programador"
    }

    override fun toIncreaseSalary() {
        currentWage += currentWage * 0.2
    }

    override fun toString(): String {
        return """
            --------------
            DADOS PROGRAMADOR
            --------------
            ID: $id
            NOME: $name
            CPF: $cpf
            SALÁRIO ATUAL: $currentWage
        """.trimIndent()
    }
}