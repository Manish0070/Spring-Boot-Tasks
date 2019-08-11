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

    //Autowiring TrackService object(Dependency Injection).
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    //User Requests Maps Here When they Tries to Save Tracks In DataBase Using Method(setTrack).
    @PostMapping("tracks")
    public ResponseEntity<?> setTrack(@RequestBody Track track) throws TrackAlreadyExistException,Exception {
        ResponseEntity responseEntity;

        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("sucessfully created", HttpStatus.CREATED); //If Sucessfuly Saved Users Tracks Returns "Sucessfully Created".

        return responseEntity;
    }
    //User Requests Maps Here When Users Retreving Tracks Using Track ID From DataBase Using Method(getById).
    @GetMapping("tracks/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws TrackNotFoundException,Exception {
        ResponseEntity responseEntity;

        trackService.getById(id);
        responseEntity = new ResponseEntity<String>("retreived by id", HttpStatus.CREATED);

        return responseEntity;

    }
    //User Requests Maps Here When User Retreving All The Tracks from  DataBase using method (getAllTracks)
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() throws TrackNotFoundException,Exception {
        ResponseEntity responseEntity;

        trackService.getAllTracks();
        responseEntity = new ResponseEntity("Retreived All Tracks", HttpStatus.OK);
        System.out.println(responseEntity);

        return responseEntity;
    }
    //User Requests Maps Here when User Requests To Delete A Particular Track Using Id.Method Invoked Is deleteTrackBtId.
    @DeleteMapping("tracks/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws TrackNotFoundException,Exception {
        ResponseEntity responseEntity;

        trackService.deleteTrackById(id);
        responseEntity = new ResponseEntity("deleted sucessfully", HttpStatus.OK);

        return responseEntity;
    }
    //User Requests Maps Here when User Requests To Update A Particular Track Using Id And track Object.Method Invoked Is updateTrack.
    @PutMapping("tracks/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @RequestBody Track track) throws TrackNotFoundException,Exception {
        Track updatedTrack = trackService.updateTrack(id, track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
    //User Requests Maps Here when User Requests To Get Track By Name Using Name.Method Invoked Is getByName.
    @GetMapping("tracks/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) throws TrackNotFoundException,Exception {
        ResponseEntity responseEntity;

        trackService.getTrackName(name);
        responseEntity = new ResponseEntity("Name Mapped", HttpStatus.OK);


        return responseEntity;
    }
}


