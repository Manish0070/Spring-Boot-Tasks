//package com.stackroute.trackservice.service;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.exception.TrackAlreadyExistException;
//import com.stackroute.trackservice.exception.TrackNotFoundException;
//import org.springframework.context.annotation.Profile;
//
//import java.util.List;
//import java.util.Optional;
//@Profile("prod")
//public class TrackDummyServiceImpl implements TrackService {
//
//    public TrackDummyServiceImpl() {
//    }
//
//    @Override
//    public Track saveTrack(Track track) throws TrackAlreadyExistException {
//        return null;
//    }
//
//    @Override
//    public Optional<Track> getById(int id) throws TrackNotFoundException {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Track> getAllTracks() throws TrackNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Optional<Track> trackdelById(int id) throws TrackNotFoundException {
//        return Optional.empty();
//    }
//
//    @Override
//    public Track updateTrack(int id, Track track) {
//        return null;
//    }
//
////    @Override
////    public Track getTrackName(String name) throws TrackNotFoundException {
////        return null;
////    }
//}
