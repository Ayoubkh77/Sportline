package org.ldv.sporline.dao

import org.ldv.sporline.entity.Couleur
import org.springframework.data.jpa.repository.JpaRepository

interface CouleurDAO : JpaRepository<Couleur, Long>
