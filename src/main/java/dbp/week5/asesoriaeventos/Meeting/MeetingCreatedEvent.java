package dbp.week5.asesoriaeventos.Meeting;

import com.fasterxml.jackson.databind.JsonNode;
import dbp.week5.asesoriaeventos.User.domain.User;
import org.springframework.context.ApplicationEvent;

public class MeetingCreatedEvent extends ApplicationEvent {
    private User user;
    private JsonNode responseBody;

    public MeetingCreatedEvent(Object source, User user, JsonNode responseBody) {
        super(source);
        this.user = user;
        this.responseBody = responseBody;
    }

    public User getUser() {
        return user;
    }

    public JsonNode getResponseBody() {
        return responseBody;
    }
}
