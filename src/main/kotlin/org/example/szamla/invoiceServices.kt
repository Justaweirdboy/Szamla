package org.example.szamla

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*

interface MessageRepository : CrudRepository<invoiceModel, Int>

@Service
class invoiceServices(val db: MessageRepository) {

    fun findInvoices(): List<invoiceModel> = db.findAll().toList()

    fun findInvoiceById(id: Int): List<invoiceModel> = db.findById(id).toList()

    fun save(invoice: invoiceModel) {
        if(invoice.issueDate > invoice.dueDate){
            throw IllegalArgumentException("issue date is after due date")
        }
        db.save(invoice)
    }

    fun deleteInvoice(id: Int) = db.deleteById(id)

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}

