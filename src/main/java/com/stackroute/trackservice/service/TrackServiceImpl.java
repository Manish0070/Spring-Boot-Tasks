package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
//@Profile("dev")
@PropertySource("classpath:application.properties")

public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl( TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistException("Track already exists");
        }
        Track saveduser = trackRepository.save(track);
        if(saveduser==null){
            throw new TrackAlreadyExistException("Track already exist");
        }
        return saveduser;
    }
    @Profile("dev")
    @Override
    public Optional<Track> getById(int id) throws TrackNotFoundException{
         if(!trackRepository.findById(id).isPresent()){

            throw new TrackNotFoundException("Track Not Found");
        }
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        List<Track> trackList = trackRepository.findAll();
        if(trackList.isEmpty()){
            throw new TrackNotFoundException("Tracks Not available");
        }
        return trackList;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException{
        Optional<Track> delete = trackRepository.findById(id);
        if(!delete.isPresent()){
            throw new TrackNotFoundException("No Tracks To Delete");
        }

       else {
            trackRepository.deleteById(id);
        }
        return delete;
    }
    @Override
    public Track updateTrack(int id, Track track)  {
        Track update = trackRepository.findById(id).get();
        update.setName(track.getName());
        update.setComments(track.getComments());
        return trackRepository.save(track);
    }
    //@Profile("prod")
    @Override
    public Track getTrackName(String name) throws TrackNotFoundException{
        Track getname=trackRepository.findByName(name);
        if(getname==null){
            throw  new TrackNotFoundException("Name not found Exception");
        }
        return getname;
    }
}
