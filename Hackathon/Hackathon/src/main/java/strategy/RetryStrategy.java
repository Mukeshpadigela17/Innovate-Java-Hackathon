package strategy;

public interface RetryStrategy {
  long getWaitTime(int attempt);
}
