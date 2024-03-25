package TO_G1Spring61.demo.service;

import TO_G1Spring61.demo.model.Request;
import TO_G1Spring61.demo.repository.RequestRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RequestService {
    @Autowired
    private RequestRepository requestsRepository;

    @Autowired
    private HistoryService historyService;
    public List<Request> getSortedRequests() {
        List<Request> request = requestsRepository.findAll();
        return request;
    }

    public Request addRequest(Request requests) {
        return requestsRepository.save(requests);
    }

    public void deleteRequest(Long id) {
        requestsRepository.deleteById(id);
    }

    public Request getRequestsById(Long id) {
        return requestsRepository.findById(id).orElse(null);
    }

    @Transactional
    public Request editRequest(Request updatedRequest) {
        Request currentRequest = getRequestsById(updatedRequest.getId());
        historyService.addHistory(currentRequest, updatedRequest);
        updatedRequest.setUserName(null);
        Request saved = requestsRepository.save(updatedRequest);
        log.info("UPDATED requests_new ID:{}", saved.getId());
        return saved;
    }
}
