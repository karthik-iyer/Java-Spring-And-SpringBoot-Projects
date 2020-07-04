package com.pluralsight.com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository speakerRepository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker> findAll(){
        return speakerRepository.findAll();
    }


}
