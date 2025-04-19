package job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.RetryService;

@Component
public class RetryJob implements Job {

    @Autowired
    private RetryService retryService;

    public void execute(JobExecutionContext context) {
        String transactionId = (String) context.getJobDetail();
        retryService.retryTransaction(transactionId);
    }
}
