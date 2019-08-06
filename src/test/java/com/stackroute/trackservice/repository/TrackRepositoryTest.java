package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp() {
        track = new Track();
        track.setName("John");
        track.setId(101);
        track.setComments("Hello");

    }

    @After
    public void tearDown() throws Exception {
        trackRepository.deleteAll();
    }

    @Test
    public void findByName() {
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findByName(track.getName());
        assertEquals("John", fetchTrack.getName());

    }

    @Test
    public void testTosaveTrack() {
        trackRepository.save(track);
        Track save = trackRepository.findById(track.getId()).get();
        assertEquals(101, save.getId());
    }

    @Test
    public void testGetAllTrack() {
        Track saveTrack1 = new Track(102, "Manish", "Hello Manish");
        Track saveTrack2 = new Track(103, "Krishna", "Hello Krishna");
        trackRepository.save(saveTrack1);
        trackRepository.save(saveTrack2);
        List<Track> list = trackRepository.findAll();
        assertEquals("Manish", list.get(0).getName());

    }

    @Test
    public void testToNotSaveAnyTracks() {
        Track newTrack = new Track(12, "Beautiful", "Restful Evening");
        trackRepository.save(newTrack);
        assertNotSame(track, newTrack);
    }
    @Test
    public void testToGetAllTheTracks() {
        Track t1 = new Track(2, "soul", "soft metallic");
        Track t2 = new Track(3, "Lambhorgini", "soft");
        Track t3 = new Track(4, "Dhimmak Karaab", "Mass");
        trackRepository.save(t1);
        trackRepository.save(t2);
        trackRepository.save(t3);
        List<Track> trackList = trackRepository.findAll();
        assertEquals("Dhimmak Karaab", trackList.get(2).getName());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testToGetAllTheTracksThrowsException() {
        Track t1 = new Track(2, "Melody", "soft metallic");
        Track t2 = new Track(3, "Pop", "soft rock");
        Track t3 = new Track(4, "dance", "hiphop");
        trackRepository.save(t1);
        trackRepository.save(t2);
        trackRepository.save(t3);
        List<Track> trackList = trackRepository.findAll();
        assertEquals("teardrop", trackList.get(5).getName());
    }
    @Test
    public void testToGetTrackById() {
        Track t1 = new Track();
        Track t2 = new Track(2, "soul", "soft metallic");
        Track t3 = new Track(3, "teardrop", "soft rock");
        trackRepository.save(t2);
        trackRepository.save(t3);
        t1.setId(3);
        Track t4 = trackRepository.findById(t1.getId()).get();
        assertEquals(t3, t4);
    }
    @Test(expected = NoSuchElementException.class)
    public void testToGetTrackByIdThrowsException() {
        Track t1 = new Track();
        Track t2 = new Track(2, "soul", "soft metallic");
        Track t3 = new Track(3, "teardrop", "soft rock");
        trackRepository.save(t2);
        trackRepository.save(t3);
        t1.setId(4);
        trackRepository.findById(t1.getId()).get();
    }
    @Test
    public void testToDeleteTrackByIdReturnsException() {
        Track t1 = new Track(2, "Sahoo", "soft rock");
        trackRepository.save(t1);
        assertNotSame(false, trackRepository.existsById(t1.getId()));
        trackRepository.deleteById(t1.getId());
    }
    @Test
    public void testToUpdateTrackFoundById() {
        Track t1 = new Track(2, "soul", "soft metallic");
        Track t2 = new Track(3, "teardrop", "soft rock");
        Track t3 = new Track(4, "dance", "hiphop");
        trackRepository.save(t1);
        trackRepository.save(t2);
        trackRepository.save(t3);
        Track trackList = trackRepository.findById(t2.getId()).get();
        trackList.setName(t3.getName());
        assertEquals(trackList.getName(), t3.getName());
    }
    @Test
    public void testToUpdateChecksForNotNull() {
        assertNotNull(trackRepository.existsById(track.getId()));
    }
    @Test
    public void testToFindByNameChecksForNotEquality(){
        trackRepository.save(track);
        Track t1 = trackRepository.findByName(track.getName());
        assertNotEquals("soul",t1.getName());
    }
}
