package org.ldv.sporline.entity

import jakarta.persistence.*

@Entity
@Table(name = "images")
class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var url: String = "",

    @Column(nullable = true)
    var altText: String? = null,

    @Column(nullable = true)
    var ordre: Int? = null
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variation_id")
    var variation: Variation? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    var produit: Produit? = null
}
