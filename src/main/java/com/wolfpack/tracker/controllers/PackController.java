package com.wolfpack.tracker.controllers;

import com.wolfpack.tracker.data.dto.PackPlusWolvesDTO;
import com.wolfpack.tracker.data.entities.Pack;
import com.wolfpack.tracker.data.entities.Wolf;
import com.wolfpack.tracker.helpers.UriHelper;
import com.wolfpack.tracker.services.PacksService;
import com.wolfpack.tracker.services.WolvesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v00/packs")
public class PackController {
    private PacksService service;
    private WolvesService wolvesService;


    public PackController(PacksService service, WolvesService wolvesService) {
        this.service = service;
        this.wolvesService = wolvesService;
    }

    @GetMapping
    public ResponseEntity<List<Pack>> getAllPacks(){
        List<Pack> allPacks = service.getAllPacks();
        return ResponseEntity.ok(allPacks);
    }

    @PostMapping
    public ResponseEntity<Void> createPack(@Valid @RequestBody Pack pack){
        var createdPack = service.createPack(pack);
        URI location = UriHelper.buildNewResourceUri(createdPack.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pack> getOnePack(@PathVariable("id") Long id){
        var pack = service.getOnePack(id);
        return  ResponseEntity.ok(pack);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePack(@PathVariable("id") Long id, @Valid @RequestBody Pack pack){
        service.updatePack(id, pack);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePack(@PathVariable("id") Long id){
        service.deletePack(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/wolves")
    public ResponseEntity<List<Wolf>> getPacksWolves(@PathVariable("id") Long packId){
        var wolves = wolvesService.getWolvesInPack(packId);
        return ResponseEntity.ok(wolves);
    }

    @GetMapping("/wolves")
    public ResponseEntity<List<PackPlusWolvesDTO>> getAllPacksPlusWolves(){
        var allPacksPlusWolves  = service.getAllPacksPlusWolves();
        return ResponseEntity.ok(allPacksPlusWolves);
    }

}
