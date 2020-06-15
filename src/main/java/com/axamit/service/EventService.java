package com.axamit.service;

import com.axamit.dto.ResponseForDay;
import com.axamit.dto.ResponseForPeriod;
import com.axamit.entity.Page;
import com.axamit.entity.User;
import com.axamit.entity.Visit;
import com.axamit.exception.PageException;
import com.axamit.exception.UserException;
import com.axamit.repository.PageRepository;
import com.axamit.repository.UserRepository;
import com.axamit.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EventService {

    private final VisitRepository visitRepository;

    private final UserRepository userRepository;

    private final PageRepository pageRepository;

    @Autowired
    public EventService(VisitRepository visitRepository, UserRepository userRepository, PageRepository pageRepository) {
        this.visitRepository = visitRepository;
        this.userRepository = userRepository;
        this.pageRepository = pageRepository;
    }


    @Async("asyncExecutor")
    @Transactional
    public ResponseForDay save(final String userId, Long pageId) {

        log.info("trying to save");
        final User user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found"));
        final Page page = pageRepository.findById(pageId).orElseThrow(() -> new PageException("Page not found"));
        visitRepository.save(new Visit(user, page));
        List<Visit> visits = visitRepository.findVisitsLastDay();
        Set<String> uniqueUsers = visits.stream()
                .map(a -> a.getUser().getId())
                .collect(Collectors.toSet());

        return new ResponseForDay(visits.size(), uniqueUsers.size());
    }

    @Transactional(readOnly = true)
    public ResponseForPeriod getDataForPeriod(final Date from, final Date to) {

        List<Visit> visits = visitRepository.findVisitsForPeriod(from, to);
        Set<String> uniqueUsers = visits.stream()
                .map(a -> a.getUser().getId())
                .collect(Collectors.toSet());
        List<User> users =visits.forEach(a->a.);
        ResponseForPeriod responseStatisticsForPeriod = new ResponseForPeriod(visits.size(),uniqueUsers.size());
        return responseStatisticsForPeriod;

    }

}
