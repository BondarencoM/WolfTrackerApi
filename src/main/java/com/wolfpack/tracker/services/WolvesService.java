package com.wolfpack.tracker.services;

import com.wolfpack.tracker.data.entities.Wolf;
import com.wolfpack.tracker.data.repositories.WolfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WolvesService {

    private WolfRepository repository;

    public WolvesService(WolfRepository repository) {
        this.repository = repository;
    }

    public List<Wolf> getAllWolves(){
        return  repository.findAll();
    }

    public void createWolf(Wolf wolf){
        repository.save(wolf);
    }
}
