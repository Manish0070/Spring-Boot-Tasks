package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/")
public class TrackController {
    private TrackService trackService;


    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    @PostMapping("track")
    public ResponseEntity<?> setTrack(@RequestBody Track track) {
        Track savedUser = trackService.saveTrack(track);
        System.out.println(savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Track retreive = trackService.getById(id);
        System.out.println(retreive);
        return new ResponseEntity<>(retreive, HttpStatus.OK);

    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        List<Track> getAllTrackList = trackService.getAllTracks();
        System.out.println(getAllTrackList);
        return new ResponseEntity<>(getAllTrackList, HttpStatus.CREATED);
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> trackdelById(@PathVariable int id) {
        Optional<Track> deleted = trackService.trackdelById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
        Track updatedTrack=trackService.updateTrack(id,track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
    @GetMapping("tracke/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        Track getname=trackService.getTrackName(name);
        return new ResponseEntity<>(getname,HttpStatus.OK);
    }

    }


