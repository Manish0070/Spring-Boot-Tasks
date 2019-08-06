package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistException;
    public Optional<Track> getById(int id) throws TrackNotFoundException;
    List<Track> getAllTracks() throws TrackNotFoundException;
    Optional<Track> deleteTrackById(int id) throws TrackNotFoundException;
    public Track  updateTrack(int id, Track track);
      public Track getTrackName(String name) throws TrackNotFoundException;
}

