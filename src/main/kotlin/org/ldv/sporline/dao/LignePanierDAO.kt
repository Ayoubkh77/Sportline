package org.ldv.sporline.dao

import org.ldv.sporline.entity.LignePanier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LignePanierDAO : JpaRepository<LignePanier, Long>
