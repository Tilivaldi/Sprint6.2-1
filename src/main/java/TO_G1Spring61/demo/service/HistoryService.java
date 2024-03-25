package TO_G1Spring61.demo.service;

import TO_G1Spring61.demo.model.History;
import TO_G1Spring61.demo.model.Course;
import TO_G1Spring61.demo.model.Request;
import TO_G1Spring61.demo.repository.HistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public History addHistory(Request current, Request updated) {
        History history = History.builder()
                .oldValue(String.valueOf(current.getHandled()))
                .newValue(String.valueOf(updated.getHandled()))
                .createdAt(LocalDateTime.now())
                .build();
        History saved = historyRepository.save(history);
        log.info("CREATED history ID:{}", saved.getId());
        return saved;
    }
}
