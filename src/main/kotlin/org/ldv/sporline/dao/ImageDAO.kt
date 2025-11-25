package org.ldv.sporline.dao

import org.ldv.sporline.entity.Image
import org.springframework.data.jpa.repository.JpaRepository

interface ImageDAO : JpaRepository<Image, Long>
