package org.ldv.sporline.dao

import org.ldv.sporline.entity.Taille
import org.springframework.data.jpa.repository.JpaRepository

interface TailleDAO : JpaRepository<Taille, Long>
