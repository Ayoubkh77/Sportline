package org.ldv.sporline.dao

import org.ldv.sporline.entity.Variation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VariationDAO : JpaRepository<Variation, Long>
