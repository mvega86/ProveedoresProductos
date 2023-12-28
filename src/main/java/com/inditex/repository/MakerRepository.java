package com.inditex.repository;

import com.inditex.entities.Maker;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {
}
