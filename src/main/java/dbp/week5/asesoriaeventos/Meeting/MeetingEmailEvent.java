package dbp.week5.asesoriaeventos.Meeting;

import org.springframework.context.ApplicationEvent;

public class MeetingEmailEvent extends ApplicationEvent {
    private String email;
    private String name;

    public MeetingEmailEvent(Object source, String email, String name) {
        super(source);
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
