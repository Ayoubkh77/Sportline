package org.ldv.sporline.dao

import org.ldv.sporline.entity.Avis
import org.springframework.data.jpa.repository.JpaRepository

interface AvisDAO : JpaRepository<Avis, Long>
