package com.ctt.exerciciodois

class BrazilContact(override val name: String, override val phoneNumber: String) :Contact {
    override fun isPhoneValid(): Boolean {
        if (phoneNumber.length < 14){
            return false
        }

        return phoneNumber.indexOf("+55") == 0
    }

    override fun getType(): String {
        return "Brasil"
    }

    override fun toString(): String {
        return """
        Nome:${name} 
        Número: ${phoneNumber}
        País: ${getType()}
        -------------------
        """.trimIndent()
    }
}