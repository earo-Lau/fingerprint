package com.fingerprint.dao;

import com.fingerprint.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lauearo on 07/06/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
