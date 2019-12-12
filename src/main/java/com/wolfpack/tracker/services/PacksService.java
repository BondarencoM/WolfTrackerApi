package com.wolfpack.tracker.services;

import com.wolfpack.tracker.data.dto.PackPlusWolvesDTO;
import com.wolfpack.tracker.data.entities.Pack;
import com.wolfpack.tracker.data.entities.Wolf;
import com.wolfpack.tracker.data.repositories.PackRepository;
import com.wolfpack.tracker.helpers.HibernateHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacksService {

    private PackRepository repository;
    private WolvesService wolvesService;

    public PacksService(PackRepository repository, WolvesService wolvesService) {
        this.repository = repository;
        this.wolvesService = wolvesService;
    }

    public List<Pack> getAllPacks(){
        return repository.findAll();
    }

    public Pack createPack(Pack pack){
        return repository.save(pack);
    }

    public Pack getOnePack(Long id) {
        var pack = repository.getOne(id);
        return HibernateHelper.resolveProxy(pack);
    }


    public void updatePack(Long id, Pack pack) {
        pack.setId(id);
        repository.save(pack);
    }

    public void deletePack(Long id) {
        List<Wolf> wolvesOfDeletedPack = wolvesService.getWolvesInPack(id);
        wolvesOfDeletedPack.forEach(this::removePack);

        repository.deleteById(id);

    }
    void removePack(Wolf wolf){
        wolf.setPack(null);
    }

    public List<PackPlusWolvesDTO> getAllPacksPlusWolves() {
        var allPacks = getAllPacks();
        var packsDTO = new ArrayList<PackPlusWolvesDTO>(allPacks.size());
        for(var pack : allPacks){
            List<Wolf> wolves = wolvesService.getWolvesInPack(pack.getId());
            var packPlusWolvesDTO = new PackPlusWolvesDTO(pack, wolves);
            packsDTO.add(packPlusWolvesDTO);
        }

        return packsDTO;
    }
}
