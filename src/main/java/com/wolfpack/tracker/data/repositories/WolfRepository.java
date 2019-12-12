package com.wolfpack.tracker.data.repositories;

import com.wolfpack.tracker.data.entities.Wolf;
import com.wolfpack.tracker.data.entities.embeddable.Coordinates;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WolfRepository extends JpaRepository<Wolf, Long> {

    List<Wolf> getAllByPackId(Long packId);

}
