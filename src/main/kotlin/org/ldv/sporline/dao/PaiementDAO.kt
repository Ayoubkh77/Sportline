package org.ldv.sporline.dao

import org.ldv.sporline.entity.Paiement
import org.springframework.data.jpa.repository.JpaRepository

interface PaiementDAO : JpaRepository<Paiement, Long>
