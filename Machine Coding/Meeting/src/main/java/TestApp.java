import java.time.LocalDateTime;

public class TestApp {
    public static void main(String[] args) {
        MeetingRoomDao meetingRoomDao = new MeetingRoomDao();
        BookingDao bookingDao = new BookingDao();
        RedisLockService lockService = new RedisLockService();
        BookingService bookingService = new BookingService(lockService, bookingDao, meetingRoomDao);

        // Admin can create/delete rooms
        Admin admin = new Admin(1L, "AdminUser", meetingRoomDao);
        admin.createMeetingRoom(1L, "Conf Room A", 10, "Projector, Whiteboard");

        // Normal Users book rooms
        NormalUser alice = new NormalUser(2L, "Alice", bookingService);
        NormalUser bob = new NormalUser(3L, "Bob", bookingService);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = now.plusMinutes(30);

        boolean booked = alice.bookMeetingRoom(1L, now, end);
        System.out.println("Booking attempt by Alice: " + booked);

        boolean bookedAgain = bob.bookMeetingRoom(1L, now.plusMinutes(10), now.plusMinutes(40));
        System.out.println("Booking attempt by Bob: " + bookedAgain);
    }
}