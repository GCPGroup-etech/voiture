package com.etech.poc.voitures.services.repository;

import com.etech.poc.voitures.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author benja
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
