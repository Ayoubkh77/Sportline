package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "commandes")
class Commande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var dateCommande: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = true)
    var dateLivraison: LocalDateTime? = null,

    @Column(nullable = false)
    var statut: String = "CREATED",

    @Column(nullable = false)
    var total: Double = 0.0,

    @Column(nullable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var dateModification: LocalDateTime = LocalDateTime.now()
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null

//    @OneToOne(cascade = [CascadeType.ALL])
//    @JoinColumn(name = "paiement_id", referencedColumnName = "id")
//    var paiement: Paiement? = null

    @OneToOne
    @JoinColumn(name = "paiement_id")
    var paiement: Paiement? = null

    @OneToOne
    @JoinColumn(name = "panier_id")
    var panier: Panier? = null
}
