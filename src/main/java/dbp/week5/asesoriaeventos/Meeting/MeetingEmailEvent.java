package dbp.week5.asesoriaeventos.Meeting;

import org.springframework.context.ApplicationEvent;

public class MeetingEmailEvent extends ApplicationEvent {
    private String email;
    private String name;

    private String roomUrl;

    public MeetingEmailEvent(Object source, String email, String name, String roomUrl) {
        super(source);
        this.email = email;
        this.name = name;
        this.roomUrl = roomUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRoomUrl() {
        return roomUrl;
    }
}
