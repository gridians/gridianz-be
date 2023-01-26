package com.devember.devember.user.repository;

import com.devember.devember.card.entity.Github;
import com.devember.devember.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByGithubNumberId(Long githubNumberId);
}