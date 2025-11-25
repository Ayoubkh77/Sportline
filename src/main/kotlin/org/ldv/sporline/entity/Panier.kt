package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "paniers")
class Panier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var dateModification: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var total: Double = 0.0
) {
    @OneToMany(mappedBy = "panier", cascade = [CascadeType.ALL], orphanRemoval = true)
    var lignes: MutableList<LignePanier> = mutableListOf()

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null
}
