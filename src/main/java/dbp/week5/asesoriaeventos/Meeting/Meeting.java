package dbp.week5.asesoriaeventos.Meeting;

import dbp.week5.asesoriaeventos.User.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String meetingId;
    private String startDate;
    private String endDate;
    @Column(columnDefinition="TEXT", length = 2048)
    private String roomUrl;
    @Column(columnDefinition="TEXT", length = 2048)
    private String hostRoomUrl;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}