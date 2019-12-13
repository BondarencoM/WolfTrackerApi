package com.wolfpack.tracker.services;

import com.wolfpack.tracker.data.entities.Pack;
import com.wolfpack.tracker.data.repositories.PackRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PackValidationService {
    private PackRepository repository;

    public PackValidationService(PackRepository repository) {
        this.repository = repository;
    }

    public void assurePackExists(Long packId) {
        if (!repository.existsById(packId)) {
            throw new EntityNotFoundException("Unable to find " + Pack.class.getSimpleName() + " with id " + packId);
        }
    }

    public void assurePackExists(Pack pack) {
        assurePackExists(pack.getId());
    }
}
