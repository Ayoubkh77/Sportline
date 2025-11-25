package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "produits")
class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var nom: String = "",

    @Column(nullable = true, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(nullable = false)
    var prix: Double = 0.0,

    @Column(nullable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var dateModification: LocalDateTime = LocalDateTime.now()
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    var categorie: Categorie? = null

    @OneToMany(mappedBy = "produit", cascade = [CascadeType.ALL], orphanRemoval = true)
    var variations: MutableList<Variation> = mutableListOf()

    @OneToMany(mappedBy = "produit", cascade = [CascadeType.ALL], orphanRemoval = true)
    var images: MutableList<Image> = mutableListOf()

    @OneToMany(mappedBy = "produit", cascade = [CascadeType.ALL], orphanRemoval = true)
    var avis: MutableList<Avis> = mutableListOf()
}
