package org.ldv.sporline.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "avis")
class Avis(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var note: Int = 0,

    @Column(nullable = true, columnDefinition = "TEXT")
    var commentaire: String? = null,

    @Column(nullable = false)
    var date: LocalDateTime = LocalDateTime.now()
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    var produit: Produit? = null
}
