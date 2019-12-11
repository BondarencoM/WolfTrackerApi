package com.wolfpack.tracker.controllers;

import com.wolfpack.tracker.data.entities.Wolf;
import com.wolfpack.tracker.services.WolvesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v00/wolves")
public class WolfController {

    private WolvesService service;

    public WolfController(WolvesService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Wolf>> getAllWolves(){
        var allWolves = service.getAllWolves();
        return ResponseEntity.ok(allWolves);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createWolf(@RequestBody Wolf body){
        service.createWolf(body);
        return ResponseEntity.ok().build();
    }
}
