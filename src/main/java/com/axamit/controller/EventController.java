package com.axamit.controller;


import com.axamit.dto.ResponseForDay;
import com.axamit.dto.ResponseForPeriod;
import com.axamit.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/axamit", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    @Autowired
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/save")
    public ResponseForDay save(@RequestParam String userId, @RequestParam Long pageId) {

        ResponseForDay responseForDay =     eventService.save(userId,pageId);
        return responseForDay;

    }

    @GetMapping()
    public ResponseForPeriod getStatisticsForPeriod(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date from,
                                                    @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") Date to) {
        return eventService.getDataForPeriod(from, to);
    }
}

