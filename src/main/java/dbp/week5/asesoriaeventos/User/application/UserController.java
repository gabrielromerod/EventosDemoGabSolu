package dbp.week5.asesoriaeventos.User.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbp.week5.asesoriaeventos.Meeting.Meeting;
import dbp.week5.asesoriaeventos.Meeting.MeetingApiClient;
import dbp.week5.asesoriaeventos.Meeting.MeetingService;
import dbp.week5.asesoriaeventos.User.domain.User;
import dbp.week5.asesoriaeventos.User.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingApiClient meetingApiClient;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> parcialUpdate(@PathVariable Integer id, @RequestBody User user) {
        return ResponseEntity.ok(userService.parcialUpdate(id, user));
    }

    @PostMapping("/{userId}/meetings")
    public ResponseEntity<?> createMeeting(@PathVariable Integer userId) throws IOException, InterruptedException {
        User user = userService.findById(userId);
        meetingApiClient.createWherebyMeeting(user);
        return ResponseEntity.accepted().build();
    }

}
