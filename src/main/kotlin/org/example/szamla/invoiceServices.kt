package org.example.szamla
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

interface MessageRepository : CrudRepository<invoiceModel, Int>

@Service
class invoiceServices(val db: MessageRepository) {

    fun findInvoices(): List<invoiceModel> = db.findAll().toList()

    fun findInvoiceById(id: Int): List<invoiceModel> = db.findById(id).toList()

    fun save(invoice: invoiceModel) {
        if(invoice.issueDate > invoice.dueDate){
            throw IllegalArgumentException("issue date is after due date")  //ne legyen mar mar a kiallitas az esedekesseg utan
        }
        db.save(invoice)
    }

    fun deleteInvoice(id: Int) = db.deleteById(id)
}

