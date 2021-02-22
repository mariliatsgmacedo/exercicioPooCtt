package com.ctt.exerciciotres

class Manager(
    override val id: Int,
    override val name: String,
    override val cpf: String,
    override var currentWage: Double
) :Employee {

    override fun employeeType(): String {
        return "Gestor"
    }

    override fun toIncreaseSalary() {
        currentWage += currentWage * 0.1
    }

    override fun toString(): String {
        return """
            --------------
            DADOS GERENTE
            --------------
            ID: $id
            NOME: $name
            CPF: $cpf
            SALÁRIO ATUAL: $currentWage
        """.trimIndent()
    }
}