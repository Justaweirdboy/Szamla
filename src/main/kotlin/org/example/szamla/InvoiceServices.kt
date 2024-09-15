package org.example.szamla
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

interface MessageRepository : CrudRepository<invoiceModel, Int>

@Service
class InvoiceServices(val db: MessageRepository) {

    fun findInvoices(): List<invoiceModel> = db.findAll().toList()

    fun findInvoiceById(id: Int): invoiceModel? = db.findById(id).orElse(null)

    fun save(invoice: invoiceModel) = db.save(invoice)

    fun deleteInvoice(id: Int) = db.deleteById(id)

    fun doesInvoiceExist(id: Int): Boolean = db.existsById(id)
}

