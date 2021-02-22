package com.ctt.exercicioum

import java.text.SimpleDateFormat
import java.util.*

class Pessoa (private val name: String, private val born: String, private val height: Double){

    private fun getDaysBetween(start: Date, end: Date): Double{
        val milliToDays = 1000 * 60 * 60 * 24.0
        val diff = end.time - start.time
        return if(diff == 0L) 0.0 else diff/milliToDays
    }

    private fun getAgeInYear(): Double {
        val todayDate: Date = Calendar.getInstance().time
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val startDate = sdf.parse(born)
        return getDaysBetween(startDate,todayDate) / 365
    }
//TODO: Show day and month as like 07 de june just it
    override fun toString(): String {
        return """
         ------------------------------------ RESULTADO --------------------------------------
           $name nasceu em $born, tem ${getAgeInYear().toInt()} anos e possui $height m de altura 
         -------------------------------------------------------------------------------------
        """.trimIndent()
    }

}