package com.ngo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.model.Apiuser;

import java.util.Optional;
public interface UserRepository extends JpaRepository<Apiuser, Long> {
    Optional<Apiuser> findByUsername(String username);
}
