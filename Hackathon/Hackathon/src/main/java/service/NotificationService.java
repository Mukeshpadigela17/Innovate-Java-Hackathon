package service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async
    public void sendEmail(String txnId, boolean success) {
        System.out.println("Sending email for txn " + txnId + ", success: " + success);
    }
}
