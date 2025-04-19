package strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("FixedIntervalStrategy")
  public class FixedIntervalStrategy implements RetryStrategy {
      @Value("${retry.fixed.interval:5000}")
      private long interval;
  
      @Override
      public long getWaitTime(int attempt) {
          return interval;
      }
  }
  