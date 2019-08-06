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
@RequestMapping(value = "/api/v1/") //Maps to Controller when user requests for particular Methods.
public class TrackController {
    private TrackService trackService;

    //dependency injection of TrackService Object
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    //Mapped to the method saveTrack when requests for saveTrack.
    @PostMapping("tracks")
    public ResponseEntity<?> setTrack(@RequestBody Track track) {
        Track savedUser = trackService.saveTrack(track);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //Mapped to the method getById when requests for getTrackById
    @GetMapping("tracks/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        Track retreive = trackService.getTrackById(id);
        return new ResponseEntity<>(retreive, HttpStatus.OK);

    }
    //Mapped to the method getAllTracks when requests for getAllTracks.
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        List<Track> getAllTrackList = trackService.getAllTracks();
        return new ResponseEntity<>(getAllTrackList, HttpStatus.CREATED);
    }
    //Mapped to the method deleteTrackById when requests for deleteTrackById
    @DeleteMapping("tracks/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Optional<Track> deleted = trackService.trackdelById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    //Mapped to the method updateTrack when requests for updateTrack
    @PutMapping("tracks/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
        Track updatedTrack=trackService.updateTrack(id,track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

    }


