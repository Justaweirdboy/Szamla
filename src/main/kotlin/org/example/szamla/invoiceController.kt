package org.example.szamla

import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val service: invoiceServices) {
    @GetMapping("/")
    fun index(): List<invoiceModel> = service.findInvoices()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<invoiceModel> =
        service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody invoiceModel: invoiceModel) {
        service.save(invoiceModel)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: String) {
        service.deleteInvoice(id)
    }
}