package com.wolfpack.tracker.data.repositories;

import com.wolfpack.tracker.data.entities.Wolf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WolfRepository extends JpaRepository<Wolf, Long> {
}
