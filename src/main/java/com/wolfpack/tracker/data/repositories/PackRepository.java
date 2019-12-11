package com.wolfpack.tracker.data.repositories;

import com.wolfpack.tracker.data.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Long> {
}
