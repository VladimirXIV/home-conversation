/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srv.users.model.User;

/**
 * UserRepository.
 *
 * @author waldemar
 */
@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
}