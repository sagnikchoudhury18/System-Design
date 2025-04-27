import java.time.LocalDateTime;

public class NormalUser extends User {

    private BookingService bookingService;

    public NormalUser(long id, String name, BookingService bookingService) {
        super(id, name);
        this.bookingService = bookingService;
    }

    public boolean bookMeetingRoom(long meetingRoomId, LocalDateTime startTime, LocalDateTime endTime) {
        return bookingService.bookMeetingRoom(meetingRoomId, this.getName(), startTime, endTime);
    }
}