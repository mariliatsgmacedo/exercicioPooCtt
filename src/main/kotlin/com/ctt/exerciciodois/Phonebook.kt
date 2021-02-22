package com.ctt.exerciciodois

class Phonebook {
    private val contactList: ArrayList<Contact> = arrayListOf()

    fun addContact(contact: Contact): Boolean {
        if(isFull()) return false
        val result = contactList.filter { it.name == contact.name && it.phoneNumber == contact.phoneNumber }
        if (result.isNotEmpty()) {
            return false
        }
        contactList.add(contact)
        return true
    }

    fun getContactsList(): ArrayList<Contact> {
        return contactList
    }

    fun getContacts(name: String): List<Contact> {
        return contactList.filter { it.name == name }
    }

    fun removeContact(name: String, phoneNumber: String) : Boolean {
        val index = contactList.indexOfFirst { it.name == name && it.phoneNumber == phoneNumber}
        return if(index == -1){
             false
         } else {
             contactList.removeAt(index)
             true
         }
    }

    fun isFull(): Boolean {
        return contactList.size > 10;
    }

}

