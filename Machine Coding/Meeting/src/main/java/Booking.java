import java.time.LocalDateTime;

public class Booking {
    private long id;
    private long meetingRoomId;
    private String bookedBy;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Booking(long id, long meetingRoomId, String bookedBy, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.meetingRoomId = meetingRoomId;
        this.bookedBy = bookedBy;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public long getMeetingRoomId() {
        return meetingRoomId;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}