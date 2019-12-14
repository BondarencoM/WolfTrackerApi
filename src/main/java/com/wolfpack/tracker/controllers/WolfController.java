package com.wolfpack.tracker.controllers;

import com.wolfpack.tracker.data.Gender;
import com.wolfpack.tracker.data.dto.IdDTO;
import com.wolfpack.tracker.data.entities.Pack;
import com.wolfpack.tracker.data.entities.Wolf;
import com.wolfpack.tracker.data.entities.embeddable.Coordinates;
import com.wolfpack.tracker.helpers.UriHelper;
import com.wolfpack.tracker.services.WolvesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v00/wolves")
public class WolfController {

    private WolvesService service;

    public WolfController(WolvesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllWolves(){
        var allWolves = service.getAllWolves();
        return ResponseEntity.ok(allWolves);
    }

    @PostMapping
    public ResponseEntity<?> createWolf(@Valid @RequestBody Wolf body){
        Wolf createdWolf = service.createWolf(body);
        URI location = UriHelper.buildNewResourceUri(createdWolf.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wolf> getOneWolf(@PathVariable Long id){
        var wolf = service.getOneWolf(id);
        return ResponseEntity.ok(wolf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWolf(@PathVariable Long id, @Valid @RequestBody Wolf wolf){
        service.updateWolf(id, wolf);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWolf(@PathVariable Long id){
        service.deleteWolf(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/pack")
    public ResponseEntity<Pack> getOneWolfsPack(@PathVariable Long id){
        var wolf = service.getOneWolfsPack(id);
        return ResponseEntity.ok(wolf);
    }

    @PutMapping("/{id}/pack")
    public ResponseEntity<?> setWolfsPack(@PathVariable("id") Long wolfId, @RequestBody IdDTO pack){
        service.assignWolfToPack(wolfId, pack);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/location")
    public ResponseEntity<?> getWolfLocation(@PathVariable("id") Long wolfId){
        var location = service.getWolfLocation(wolfId);
        return ResponseEntity.ok(location);
    }

    @PutMapping("/{id}/location")
    public ResponseEntity<?> setWolfsLocation(@PathVariable("id") Long wolfId, @RequestBody Coordinates coordinates){
        service.SetWolfLocation(wolfId, coordinates);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/genders")
    public ResponseEntity<Gender[]> getAllPossibleGenders(){
        return ResponseEntity.ok(Gender.values());
    }

}
