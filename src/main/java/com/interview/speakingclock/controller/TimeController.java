package com.interview.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.speakingclock.service.TimeService;

@RestController
@RequestMapping("/")
public class TimeController {
	
    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }
    
    @GetMapping("/convertTime")
    public String retunrString() {
    	return "Welcome to Talking time";
    }


    @PostMapping("/convertTime")
    public ResponseEntity<String> convertTime(@RequestBody String time) {
        try {
            String convertedTime = timeService.convertToWords(time);
            return ResponseEntity.ok(convertedTime);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}