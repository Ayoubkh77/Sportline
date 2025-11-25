package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "paiements")
class Paiement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var montant: Double = 0.0,

    @Column(nullable = false)
    var date: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = true)
    var methode: String? = null,

    @Column(nullable = true)
    var statut: String? = null,

//    @OneToOne(mappedBy = "paiement")
//    var commande: Commande? = null
)
