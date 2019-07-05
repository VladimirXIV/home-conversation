/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srv.auth.model.Role;

/**
 * RoleRepository.
 *
 * @author waldemar
 */
@Repository(value = "roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}