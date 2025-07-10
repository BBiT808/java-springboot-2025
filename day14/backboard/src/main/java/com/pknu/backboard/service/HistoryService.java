package com.pknu.backboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pknu.backboard.entity.About;
import com.pknu.backboard.entity.History;
import com.pknu.backboard.repository.HistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryService {

    // @Autowired 는 생략 가능 !!
    private final HistoryRepository historyRepository;

    public void setHistory(About about, String year, String description) {

        History history = new History();
        history.setYear(year);
        history.setDescription(description);
        history.setAbout(about);

        historyRepository.save(history);
    }

}
