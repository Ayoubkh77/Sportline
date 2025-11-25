package org.ldv.sporline.dao

import org.ldv.sporline.entity.Produit
import org.springframework.data.jpa.repository.JpaRepository

interface ProduitDAO : JpaRepository<Produit, Long>
