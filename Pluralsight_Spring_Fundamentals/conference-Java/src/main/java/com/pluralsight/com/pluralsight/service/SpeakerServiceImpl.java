package com.pluralsight.com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService")
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

    @Override
    public List<Speaker> findAll(){
        return speakerRepository.findAll();
    }


    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
        System.out.println("In the Speaker Service Impl in the setter");
    }
}
