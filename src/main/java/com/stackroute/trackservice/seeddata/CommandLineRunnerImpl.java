//package com.stackroute.trackservice.seeddata;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//@Component
//@PropertySource("classpath:application.properties")
//
//public class CommandLineRunnerImpl implements CommandLineRunner {
//    private TrackRepository trackRepository;
//    @Autowired
//    public CommandLineRunnerImpl(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Value("${id}")
//    int id;
//    @Value("${name1}")
//    String name;
//    @Value("${comments}")
//    String comment;
//
//    @Autowired
//    private Environment environment;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Track track1=new Track(id,environment.getProperty("name"),comment);
//        trackRepository.save(track1);
//        Track track2=new Track(3,name,"nice");
//        trackRepository.save(track2);
//    }
//}
