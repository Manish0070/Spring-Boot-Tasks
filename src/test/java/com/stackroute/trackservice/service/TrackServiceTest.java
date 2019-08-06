package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    Track track;

    //Create a mock for UserRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(102);
        track.setName("Krishna");
        track.setComments("Hello");
        list = new ArrayList<>();
        list.add(track);


    }
    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedUser = trackService.saveTrack(track);
        assertEquals(track,savedUser);
        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }
    @Test(expected = TrackAlreadyExistException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedUser = trackService.saveTrack(track);
        System.out.println("savedUser" + savedUser);
        //Assert.assertEquals(user,savedUser);trackRepository

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }
    @Test
    public void getByIdTestSucess() throws TrackNotFoundException {
        trackRepository.save(track);
        Track track2=new Track(102,"Krishna","Hello");
        when(trackRepository.existsById(102)).thenReturn(true);
        when(trackRepository.findById(102)).thenReturn(Optional.of(track2));
        assertEquals(track2,track);

        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository,times(1)).save(track);
    }

    @Test(expected = TrackNotFoundException.class)
    public void getByIdTestFailure() throws TrackNotFoundException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track saveId = trackService.getById(track.getId()).get();
        System.out.println("savedUser" + saveId);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new TrackENotFoundException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getByNameTestSucess() throws TrackNotFoundException {
       trackRepository.save(track);
       when(trackRepository.findByName("Krishna")).thenReturn(track);
        Track getName = trackService.getTrackName(track.getName());
     assertEquals("Krishna",getName.getName());

        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository,times(1)).save(track);
    }
    @Test(expected = TrackNotFoundException.class)
    public void getByNameTestFailure() throws TrackNotFoundException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track saveId = trackService.getTrackName(track.getName());
        System.out.println("savedUser" + saveId);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new TrackENotFoundException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }
    @Test
    public void getAllTracks() throws Exception {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> music=trackService.getAllTracks();
        assertEquals(list,music);
    }

    @Test
    public void deletedTrackByIdTestSuccess() throws TrackNotFoundException{
            trackRepository.save(track);
            when(trackRepository.existsById(track.getId())).thenReturn(true);
            when(trackRepository.findById(track.getId())).thenReturn(java.util.Optional.of(track));
            Optional<Track> track1 = trackService.deleteTrackById(track.getId());
            assertEquals(true,trackRepository.existsById(track.getId()));
    }
    @Test
    public void updateTrackTestSuccess(){
        trackRepository.save(track);
        Track track1 = new Track();
        track1.setName("Better");
        track1.setComments("Best Track");
        when(trackRepository.findById(track.getId())).thenReturn(Optional.of(track));
        Track updateTrack =  trackService.updateTrack(102,track1);
        when(trackRepository.save(updateTrack)).thenReturn(updateTrack);
        Assert.assertNotEquals(updateTrack,track);
        verify(trackRepository,times(1)).save(track);

    }


}
