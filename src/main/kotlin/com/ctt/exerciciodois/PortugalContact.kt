package com.ctt.exerciciodois

class PortugalContact(override val name: String, override val phoneNumber: String) :Contact {
    override fun isPhoneValid(): Boolean {
        if (phoneNumber.length < 13){
            return false
        }

        return phoneNumber.indexOf("+351") == 0
    }

    override fun getType(): String {
        return "Portugal"
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