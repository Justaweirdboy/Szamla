package org.example.szamla

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table
class invoiceModel(

    val customerName: String,
    val issueDate: LocalDate,
    val dueDate: LocalDate,
    val itemName: String,
    val comment: String,
    val price: Double,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?=null,
)
