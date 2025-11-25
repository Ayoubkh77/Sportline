package org.ldv.sporline.entity

import jakarta.persistence.*

@Entity
@Table(name = "couleurs")
class Couleur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var nom: String = ""
) {
    @OneToMany(mappedBy = "couleur")
    var variations: MutableList<Variation> = mutableListOf()
}
