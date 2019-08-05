//package com.stackroute.trackservice.seeddata;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//
//@Component
//class ApplicationRunnerImpl implements ApplicationListener {
//    private TrackRepository trackRepository;
//
//    @Autowired
//    public ApplicationRunnerImpl(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        Track track1 = new Track(4, "manu", "good");
//        trackRepository.save(track1);
//        Track track2 = new Track(5, "krish", "great");
//        trackRepository.save(track2);
//        Track track3 = new Track(8, "virat", "best");
//        trackRepository.save(track3);
//    }
//}
//
