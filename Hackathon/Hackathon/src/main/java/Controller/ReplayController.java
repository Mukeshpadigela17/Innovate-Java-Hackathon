package Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/replay")
public class ReplayController {

    @PostMapping("/{txnId}")
    public ResponseEntity<String> replay(@PathVariable String txnId) {
        // Simulate replay logic
        return ResponseEntity.ok("Replayed transaction " + txnId);
    }
}
