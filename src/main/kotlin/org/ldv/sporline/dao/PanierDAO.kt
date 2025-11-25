package org.ldv.sporline.dao

import org.ldv.sporline.entity.Panier
import org.springframework.data.jpa.repository.JpaRepository

interface PanierDAO : JpaRepository<Panier, Long>
