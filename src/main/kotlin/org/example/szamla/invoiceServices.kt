package org.example.szamla

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*

interface MessageRepository : CrudRepository<invoiceModel, String>

@Service
class invoiceServices(val db: MessageRepository) {

    fun findInvoices(): List<invoiceModel> = db.findAll().toList()

    fun findMessageById(id: String): List<invoiceModel> = db.findById(id).toList()

    fun save(invoice: invoiceModel) = db.save(invoice)

    fun deleteInvoice(id: String) = db.deleteById(id)

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}

