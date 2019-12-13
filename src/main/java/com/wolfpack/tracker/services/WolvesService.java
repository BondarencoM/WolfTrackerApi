package com.wolfpack.tracker.services;

import com.wolfpack.tracker.data.dto.IdDTO;
import com.wolfpack.tracker.data.entities.Pack;
import com.wolfpack.tracker.data.entities.Wolf;
import com.wolfpack.tracker.data.entities.embeddable.Coordinates;
import com.wolfpack.tracker.data.repositories.WolfRepository;
import com.wolfpack.tracker.helpers.HibernateHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WolvesService {

    private WolfRepository repository;
    private PackValidationService packsValidationService;


    public WolvesService(WolfRepository repository, PackValidationService packsService) {
        this.repository = repository;
        this.packsValidationService = packsService;
    }

    public List<Wolf> getAllWolves(){
        return repository.findAll();
    }

    public Wolf createWolf(Wolf wolf){
        packsValidationService.assurePackExists(wolf.getPack());
        return repository.save(wolf);
    }

    public Wolf getOneWolf(Long id) {
        var found = repository.getOne(id);
        return HibernateHelper.resolveProxy(found);
    }

    public Pack getOneWolfsPack(Long id) {
        var wolf = getOneWolf(id);
        return wolf.getPack();
    }

    public void assignWolfToPack(long wolfId, IdDTO pack) {
        //TODO handle case if pack does not exist
        if(pack.getId() == null){
            removeWolfFromPack(wolfId);
        }else{
            assignWolfToPack(wolfId, pack.getId());
        }
    }
    private void removeWolfFromPack(long id){
        var wolf = repository.getOne(id);
        wolf.setPack(null);
        repository.save(wolf);
    }
    public void assignWolfToPack(Long wolfId, long packId) {
        var wolf = repository.getOne(wolfId);

        var pack = new Pack().setId(packId);
        wolf.setPack(pack);

        repository.save(wolf);

    }

    public List<Wolf> getWolvesInPack(Long packId) {
        return repository.getAllByPackId(packId);
    }

    public void updateWolf(Long id, Wolf wolf) {
        wolf.setId(id);
        repository.save(wolf);
    }

    public void deleteWolf(Long id) {
        repository.deleteById(id);
    }

    public Coordinates getWolfLocation(Long wolfId) {
        var wolf = repository.getOne(wolfId);
        return  wolf.getLocation();
    }

    public void SetWolfLocation(Long wolfId, Coordinates coordinates) {
        var wolf = repository.getOne(wolfId);
        wolf.setLocation(coordinates);
        repository.save(wolf);
    }
}
