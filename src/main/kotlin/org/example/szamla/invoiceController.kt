package org.example.szamla

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/invoices")
class MessageController(val service: InvoiceServices) {
    @GetMapping("/")
    fun index(): List<invoiceModel> = service.findInvoices()

    @GetMapping("/{id}")
    fun index(@PathVariable id: Int): ResponseEntity<invoiceModel> {
        val invoice = service.findInvoiceById(id)
        return if (invoice != null) ResponseEntity(invoice, HttpStatus.OK)
        else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun post(@RequestBody invoice: invoiceModel): ResponseEntity<invoiceModel> {
        if (invoice.issueDate > invoice.dueDate)
            return ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
        service.save(invoice)
        return ResponseEntity(invoice, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteInvoice(@PathVariable id: Int): ResponseEntity<invoiceModel> {
        if (!service.doesInvoiceExist(id))
            return ResponseEntity(HttpStatus.NOT_FOUND)
        service.deleteInvoice(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}