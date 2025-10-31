/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.usersrest.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jprof
 */
@Repository
public interface UserRepository extends
        JpaRepository<User,Integer>,
        RepositorySaveAndRefresh<User> {
    
    Optional<User> findByEmail(String email);

}
