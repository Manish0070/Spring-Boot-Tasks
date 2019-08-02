package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackNotFoundException;
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
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("sucessfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try {
            trackService.getById(id);
            responseEntity = new ResponseEntity<String>("retreived by id", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }

        return responseEntity;

    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        try {
             trackService.getAllTracks();
            responseEntity = new ResponseEntity("Retreived All Tracks", HttpStatus.OK);
            System.out.println(responseEntity);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> trackdelById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.trackdelById(id);
            responseEntity = new ResponseEntity("deleted sucessfully", HttpStatus.OK);
        } catch (TrackNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @RequestBody Track track) throws TrackNotFoundException {
        Track updatedTrack = trackService.updateTrack(id, track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

    @GetMapping("tracke/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try {
            trackService.getTrackName(name);
            responseEntity = new ResponseEntity("Name Mapped", HttpStatus.OK);
        } catch (TrackNotFoundException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

        return responseEntity;
    }
}


