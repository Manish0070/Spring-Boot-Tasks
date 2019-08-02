package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track);
    public Track getById(int id);
    List<Track> getAllTracks();
    Optional<Track> trackdelById(int id);
    public Track  updateTrack(int id, Track track);
    public Track getTrackName(String name);

}

