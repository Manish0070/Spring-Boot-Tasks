package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TrackServiceTest {
    @Autowired
    TrackRepository trackRepository;
    Track track;

}
