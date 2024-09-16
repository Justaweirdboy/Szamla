package org.example.szamla

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table
class invoiceModel(
    @Schema(description = "customer name", required = true) //pelda a schema hasznalatara
    @Column( nullable = false)
    val customerName: String,
    @Column( nullable = false)
    val issueDate: LocalDate,
    @Column( nullable = false)
    val dueDate: LocalDate,
    @Column( nullable = false)
    val itemName: String,
    @Column(nullable = false, length = 1024) //a column egy lehetseges hasznalata
    val comment: String,
    @Column( nullable = false)
    val price: Double,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?=null,
)
