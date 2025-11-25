package org.ldv.sporline.entity

import jakarta.persistence.*

@Entity
@Table(name = "tailles")
class Taille(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var nom: String = ""
) {
    @OneToMany(mappedBy = "taille")
    var variations: MutableList<Variation> = mutableListOf()
}
