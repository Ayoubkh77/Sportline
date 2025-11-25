package org.ldv.sporline.entity

import jakarta.persistence.*

@Entity
@Table(name = "ligne_panier")
class LignePanier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var quantite: Int = 0,

    @Column(nullable = false)
    var sousTotal: Double = 0.0
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "panier_id")
    var panier: Panier? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variation_id")
    var variation: Variation? = null
}
