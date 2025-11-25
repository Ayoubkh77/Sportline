package org.ldv.sporline.dao

import org.ldv.sporline.entity.Categorie
import org.springframework.data.jpa.repository.JpaRepository

interface CategorieDAO : JpaRepository<Categorie, Long>
