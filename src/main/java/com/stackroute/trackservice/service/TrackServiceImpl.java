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
    //When Controller Invokes The Method Below Method Is Executed Here(Logic For That Method).
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistException("Track already exists"); //If Track Already Exists This Message Returns.
        }
        Track saveduser = trackRepository.save(track);
        if(saveduser==null){
            throw new TrackAlreadyExistException("Track already exist");
        }
        return saveduser;
    }
    @Profile("dev")
    @Override
    //This Method Checks Track Is there,If It Is there It Returns Track else "Track Not Found" Message It Returns.
    public Optional<Track> getById(int id) throws TrackNotFoundException{
         if(!trackRepository.findById(id).isPresent()){

            throw new TrackNotFoundException("Track Not Found"); // Returns Track Not Found
        }
        return trackRepository.findById(id);//If Track Exists It Returns Track
    }
    //This Method Invokes For Getting All Tracks.
    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        List<Track> trackList = trackRepository.findAll();
        if(trackList.isEmpty()){
            throw new TrackNotFoundException("Tracks Not available");//If List Is Empty Returns  "Tracks Not available".
        }
        return trackList; //Else Returs Tracks List.
    }
    //This Method Invokes deleteTrackById to Delete A Track.
    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException{
        Optional<Track> delete = trackRepository.findById(id);
        if(!delete.isPresent()){
            throw new TrackNotFoundException("No Tracks To Delete"); //If Track Not Found Returns "No Tracks To Delete".
        }

       else {
            trackRepository.deleteById(id); //Else Delete That Track.
        }
        return delete;
    }
    @Override
    //This Method Invokes updateTrack.Update A Particular Track.
    public Track updateTrack(int id, Track track)  {
        Track update = trackRepository.findById(id).get();//Finding Track
        update.setName(track.getName());//Setting Name
        update.setComments(track.getComments());//seting comments
        return trackRepository.save(track);//Returning Updated Track.
    }
    //@Profile("prod")
    @Override
    //This Method Invokes getTrackName.
    public Track getTrackName(String name) throws TrackNotFoundException{
        Track getname=trackRepository.findByName(name);//Finding Name Is There Or Not.
        if(getname==null){
            throw  new TrackNotFoundException("Name not found Exception");//Name Is Null Returns "Name not found Exception"
        }
        return getname;//Else Return Track.
    }
}
