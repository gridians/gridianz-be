package com.gridians.gridians.domain.card.repository;

import com.gridians.gridians.domain.card.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FieldRepository extends JpaRepository<Field, Long> {
	Optional<Field> findByName(String name);
}
