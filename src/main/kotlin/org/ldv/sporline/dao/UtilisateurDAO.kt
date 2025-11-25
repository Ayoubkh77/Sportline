package org.ldv.sporline.dao

import org.ldv.sporline.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UtilisateurDAO : JpaRepository<Utilisateur, Long> {


    @Query("select u from Utilisateur u where u.email = ?1")
    fun findByEmail(email: String): Utilisateur

}
