package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {


    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> findByWhiskyByYear(@RequestParam(name = "year") int year){
        if(year != 0 ){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value="/randolph")
    public ResponseEntity<List<Whisky>> findByStuff(@RequestParam(name = "distillery") String distillery, @RequestParam(name = "age") int age) {
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(distillery, age), HttpStatus.OK);
    }
}
