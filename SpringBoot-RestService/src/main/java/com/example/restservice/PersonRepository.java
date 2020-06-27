package com.example.restservice;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {

    private static Map<String,String> personMap = new HashMap<String, String>();

    public String findPerson(String id){
        return personMap.get(id);
    }


}
