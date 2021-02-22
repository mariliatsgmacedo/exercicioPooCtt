import com.ctt.exerciciodois.BrazilContact
import com.ctt.exerciciodois.Phonebook
import com.ctt.exerciciodois.PortugalContact
import com.ctt.exerciciotres.Company
import com.ctt.exerciciotres.Manager
import com.ctt.exerciciotres.Programmer

import com.ctt.exercicioum.Pessoa
import java.util.*

fun main() {
// Exercise One
    //exerciseOne()
//Exercise Two
    //exerciseTwo()
    //Exercise Three
    exerciseThree()
}

private fun exerciseOne() {
    println("""
    -------------------
    Exercicio Um
    -------------------""")
    val person = Pessoa(name = "Marília", born = "07-06-1987", height = 1.63)
    println(person)
}

private fun exerciseTwo() {
    println("""
    -------------------
    Exercicio Dois
    -------------------""")
    val phoneB = Phonebook()

    val list = listOf(
        PortugalContact(name = "Tamiles", phoneNumber = "+351991888222"),
        PortugalContact(name = "Jim", phoneNumber = "+351775877777"),
        PortugalContact(name = "Betinho", phoneNumber = "+351881877000"),
        PortugalContact(name = "Julia", phoneNumber = "+351444777555"),
        PortugalContact(name = "Jim", phoneNumber = "+351991888000"),
        BrazilContact(name = "Mãe", phoneNumber = "+5585974575231"),
        BrazilContact(name = "Pai", phoneNumber = "+5585955575232"),
        BrazilContact(name = "Costelinha", phoneNumber = "+5575235"),
        BrazilContact(name = "Leandro", phoneNumber = "+5585912375231"),
        BrazilContact(name = "Suzana", phoneNumber = "+5585963275233"),
        BrazilContact(name = "Vó", phoneNumber = "+5585923575234"),
        BrazilContact(name = "Leandro", phoneNumber = "+5585977775235"),
        BrazilContact(name = "ttt", phoneNumber = "+5585987775231"),
    )

    //Add Contact to my phoneBook
    list.forEach {
        if (phoneB.isFull()) {
            println("Agenda cheia. Favor liberar espaço!")
        } else {
            if (!it.isPhoneValid()) {
                println("Formato inválido ${it.name}: ${it.phoneNumber} - ${it.getType()}")
            } else {
                if (phoneB.addContact(it)) {
                    println("Contato: ${it.name} Número: ${it.phoneNumber} País: ${it.getType()}")
                } else {
                    println("Contato ${it.name} ${it.phoneNumber} já existe na agenda.")
                }
            }
        }
    }

    //Remove contact to my phoneBook
    val removeContactFounded = phoneB.removeContact("Leandro", "+5585977775235")
    if (removeContactFounded) {
        println("Contato removido com sucesso!")
    } else {
        println("Contato não existe na agenda!")
    }


    //Show contact to my phoneBook
    println("""
    -------------------
    Contatos da Agenda
    -------------------""")
    phoneB.getContactsList().forEach {
        println(it)
    }

    //Search contact to my phoneBook
    println("""
    -------------------
    Contatos da Encontrados
    -------------------""")
    phoneB.getContacts("Jim").forEach {
        println(it)
    }
}

private fun exerciseThree() {
    println("""
    -------------------
    Exercicio Três
    -------------------""")

    val compVenturus = Company()

    var nextId: Int = 1

    while (true) {
        println("""
            Selecione uma das opções abaixo:
            1 - Cadastrar funcionário
            2 - Pesquisar funcionário
            3 - Sair
            """.trimIndent())
        when (Scanner(System.`in`).nextInt()) {
            1 -> {
                addEmployeeOption(nextId, compVenturus)
                nextId++
            }

            2 -> {
                searchEmployee(compVenturus)
            }

            3 -> {
                println("Sistema encerrado")
                break
            }
            else -> println("Opção Inválida!")
        }
    }
}

private fun addEmployeeOption(nextId: Int, compVenturus: Company) {
    println("Informe o nome:")
    val name = Scanner(System.`in`).nextLine()

    println("Informe o cpf:")
    val cpf = Scanner(System.`in`).nextLine()

    println("Informe o salário atual:")
    val currentSalary = Scanner(System.`in`).nextDouble()

    println("""
                Escolha o tipo de funcionário:
                1 - Gerente
                2 - Programador
                Digite qualquer outro número para mostrar o Menu principal.
                """.trimIndent())
    when (Scanner(System.`in`).nextInt()) {
        1 -> {
            val manager = Manager(nextId, name, cpf, currentSalary)
            compVenturus.saveEmployee(manager)
            println("${manager.employeeType()} salvo com sucesso! $manager")
        }
        2 -> {
            val programmer = Programmer(nextId, name, cpf, currentSalary)
            compVenturus.saveEmployee(programmer)
            println("${programmer.employeeType()} com sucesso! $programmer")
        }
        else -> println("Carregando Menu Principal")
    }
    println()
}

private fun searchEmployee(compVenturus: Company) {
    println("Informe o ID do funcionário: ")
    val empId = Scanner(System.`in`).nextInt()
    val employeeFounded = compVenturus.getEmployeeById(empId)
    if (employeeFounded == null) {
        println("Funcionário não encontrado.")
        println()
        return
    }

    println("""
            Selecione uma das opções abaixo:
            1 - Mostrar dados
            2 - Aumentar Salário
            Digite qualquer outro número para mostrar o Menu principal.
            """.trimIndent())

    val option = Scanner(System.`in`).nextInt()

    if (option == 1) {
        println(employeeFounded)
    } else if (option == 2) {
        employeeFounded.toIncreaseSalary()
        println(employeeFounded)
    } else {
        println("Carregando menu principal")
    }


}

