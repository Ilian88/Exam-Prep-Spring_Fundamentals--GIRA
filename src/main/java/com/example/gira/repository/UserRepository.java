package com.example.gira.repository;

import com.example.gira.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Boolean existsByUsernameAndEmail(String username,String password);

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
