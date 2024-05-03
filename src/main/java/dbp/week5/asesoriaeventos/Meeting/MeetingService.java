package dbp.week5.asesoriaeventos.Meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import dbp.week5.asesoriaeventos.User.domain.User;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Async
    public void createMeetingAsync(User user, String meetingId, String startDate, String endDate, String roomUrl, String hostRoomUrl) {
        Meeting meeting = new Meeting();
        meeting.setMeetingId(meetingId);
        meeting.setStartDate(startDate);
        meeting.setEndDate(endDate);
        meeting.setRoomUrl(roomUrl);
        meeting.setHostRoomUrl(hostRoomUrl);
        meeting.setUser(user);
        meetingRepository.save(meeting);
    }
}
