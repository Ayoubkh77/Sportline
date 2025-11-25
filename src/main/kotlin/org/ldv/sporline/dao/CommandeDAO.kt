package org.ldv.sporline.dao

import org.ldv.sporline.entity.Commande
import org.springframework.data.jpa.repository.JpaRepository

interface CommandeDAO : JpaRepository<Commande, Long>
