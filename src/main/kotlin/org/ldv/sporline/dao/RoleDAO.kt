package org.ldv.sporline.dao

import org.ldv.sporline.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long>
