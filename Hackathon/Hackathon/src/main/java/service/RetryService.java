package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import strategy.RetryStrategy;
//import org.springframework.transaction.annotation.Transactional;
@Service
public class RetryService {

    private final Map<String, RetryStrategy> strategyMap;

    public RetryService(List<RetryStrategy> strategies) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(s -> s.getClass().getSimpleName(), s -> s));
    }

    public void retryTransaction(String txnId) {
        int attempt = 1; // Fetch from DB in real implementation
        RetryStrategy strategy = strategyMap.get("FixedIntervalStrategy");

        long waitTime = strategy.getWaitTime(attempt);

        System.out.println("Retrying txnId: " + txnId + ", waitTime: " + waitTime);
        // Simulate retry logic
    }
}
