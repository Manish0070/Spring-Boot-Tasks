package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track saveduser = trackRepository.save(track);
        return saveduser;
    }

    @Override
    public Track getById(int id) {
        Track retreiveduser = trackRepository.findById(id).get();
        return retreiveduser;
    }

    @Override
    public List<Track> getAllTracks() {
        List<Track> trackList = trackRepository.findAll();
        return trackList;
    }

    @Override
    public Optional<Track> trackdelById(int id) {
        Optional<Track> delete = trackRepository.findById(id);

        if (delete.isPresent()) {
            trackRepository.deleteById(id);
        }
        return delete;
    }
    @Override
    public Track updateTrack(int id, Track track) {
        Track update = trackRepository.findById(id).get();
        update.setName(track.getName());
        update.setComments(track.getComments());
        return trackRepository.save(track);
    }
    @Override
    public Track getTrackName(String name){
        Track getname=trackRepository.getTrackByName(name);
        return getname;
    }
}
