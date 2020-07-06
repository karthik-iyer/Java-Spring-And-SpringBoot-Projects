package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository speakerRepository;

    public SpeakerServiceImpl(){
        System.out.println("In the Speaker Service Impl no args Constructor");
    }

    @Autowired
    public SpeakerServiceImpl(SpeakerRepository speakerRepository){
        this.speakerRepository = speakerRepository;
        System.out.println("In the Speaker Service Impl speakerRepository Constructor");
    }

    @PostConstruct
    private void initialize(){
        System.out.println("Called after the constructors");
    }
    @Override
    public List<Speaker> findAll(){
        return speakerRepository.findAll();
    }


    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
        System.out.println("In the Speaker Service Impl in the setter");
    }
}
