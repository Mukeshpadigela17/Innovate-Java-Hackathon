package Controller;

import org.apache.kafka.common.utils.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.Trigger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job.RetryJob;

@RestController
@RequestMapping("/api/retry")
public class RetryController {

    private static final String TriggerBuilder = null;
    @Autowired
    private Scheduler scheduler;

    @PostMapping("/{txnId}")
    public ResponseEntity<String> scheduleRetry(@PathVariable String txnId) {
        try {
            JobDetail job = JobBuilder.newJob(RetryJob.class)
                    .withIdentity(txnId)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .startNow()
                    .build();

            scheduler.scheduleJob(job, trigger);

            return ResponseEntity.ok("Scheduled retry for txnId: " + txnId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
