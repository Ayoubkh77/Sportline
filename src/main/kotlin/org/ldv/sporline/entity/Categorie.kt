package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "categories")
class Categorie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var nom: String = "",

    @Column(nullable = true)
    var description: String? = null,

    @Column(nullable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now()
) {
    @OneToMany(mappedBy = "categorie", cascade = [CascadeType.ALL], orphanRemoval = true)
    var produits: MutableList<Produit> = mutableListOf()
}
