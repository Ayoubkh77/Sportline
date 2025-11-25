package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "utilisateurs")
class Utilisateur(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var nom: String = "",

    @Column(nullable = false)
    var prenom: String = "",

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var motDePasse: String = "",

    var telephone: String? = null,

    @Column(nullable = false, updatable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var dateModification: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: Role? = null
) {

    @OneToMany(mappedBy = "utilisateur", cascade = [CascadeType.ALL], orphanRemoval = true)
    var avis: MutableList<Avis> = mutableListOf()

    @OneToMany(mappedBy = "utilisateur", cascade = [CascadeType.ALL])
    var commandes: MutableList<Commande> = mutableListOf()

    @OneToOne(mappedBy = "utilisateur", cascade = [CascadeType.ALL])
    var panier: Panier? = null

    @PreUpdate
    fun preUpdate() {
        dateModification = LocalDateTime.now()
    }
}
