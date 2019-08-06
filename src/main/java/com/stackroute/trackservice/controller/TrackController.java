package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
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
    public ResponseEntity<?> setTrack(@RequestBody Track track) throws TrackAlreadyExistException {
        ResponseEntity responseEntity;

        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("sucessfully created", HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        trackService.getById(id);
        responseEntity = new ResponseEntity<String>("retreived by id", HttpStatus.CREATED);

        return responseEntity;

    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() throws TrackNotFoundException {
        ResponseEntity responseEntity;

        trackService.getAllTracks();
        responseEntity = new ResponseEntity("Retreived All Tracks", HttpStatus.OK);
        System.out.println(responseEntity);

        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        trackService.deleteTrackById(id);
        responseEntity = new ResponseEntity("deleted sucessfully", HttpStatus.OK);

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

        trackService.getTrackName(name);
        responseEntity = new ResponseEntity("Name Mapped", HttpStatus.OK);


        return responseEntity;
    }
}


