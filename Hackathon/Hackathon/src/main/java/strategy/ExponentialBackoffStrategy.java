package strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ExponentialBackoffStrategy")
public class ExponentialBackoffStrategy implements RetryStrategy {
    @Value("${retry.backoff.base:2000}")
    private long baseDelay;

    @Override
    public long getWaitTime(int attempt) {
        return (long) (baseDelay * Math.pow(2, attempt));
    }
}
