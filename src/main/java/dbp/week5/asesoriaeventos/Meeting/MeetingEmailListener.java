package dbp.week5.asesoriaeventos.Meeting;

import dbp.week5.asesoriaeventos.Email.domain.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MeetingEmailListener {

    @Autowired
    private EmailService emailService;

    @EventListener
    @Async
    public void sendMeetingEmail(MeetingEmailEvent meetingEmailEvent) {
        emailService.sendEmail(meetingEmailEvent.getEmail(), "Meeting", "Hola " + meetingEmailEvent.getName() + ", tienes una reunión programada.");
    }
}
