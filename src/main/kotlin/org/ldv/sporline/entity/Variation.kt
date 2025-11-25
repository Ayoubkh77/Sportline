package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "variations")
class Variation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var stock: Int = 0,

    @Column(nullable = false)
    var prix: Double = 0.0,

    @Column(nullable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var dateModification: LocalDateTime = LocalDateTime.now()
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id", nullable = false)
    var produit: Produit? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couleur_id")
    var couleur: Couleur? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taille_id")
    var taille: Taille? = null

    @OneToMany(mappedBy = "variation", cascade = [CascadeType.ALL], orphanRemoval = true)
    var images: MutableList<Image> = mutableListOf()
}
