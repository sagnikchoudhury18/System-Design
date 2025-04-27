import java.time.LocalDateTime;
import java.util.List;

public class BookingService {
    private RedisLockService lockService;
    private BookingDao bookingDao;
    private MeetingRoomDao meetingRoomDao;

    public BookingService(RedisLockService lockService, BookingDao bookingDao, MeetingRoomDao meetingRoomDao) {
        this.lockService = lockService;
        this.bookingDao = bookingDao;
        this.meetingRoomDao = meetingRoomDao;
    }

    public boolean bookMeetingRoom(long meetingRoomId, String bookedBy, LocalDateTime startTime, LocalDateTime endTime) {
        boolean lockAcquired = lockService.acquireLock(meetingRoomId);

        if (!lockAcquired) {
            System.out.println("Could not acquire lock. Another booking is in progress.");
            return false;
        }

        try {
            // Validate time slot
            List<Booking> existingBookings = bookingDao.getBookingsForRoom(meetingRoomId);
            for (Booking booking : existingBookings) {
                if (startTime.isBefore(booking.getEndTime()) && endTime.isAfter(booking.getStartTime())) {
                    System.out.println("Already booked for this time slot.");
                    return false;
                }
            }

            // Validate max duration (30 mins)
            if (startTime.plusMinutes(30).isBefore(endTime)) {
                System.out.println("Booking exceeds 30 minutes limit.");
                return false;
            }

            // Validate booking range (within 1 day)
            if (startTime.plusDays(1).isBefore(endTime)) {
                System.out.println("Booking exceeds allowed booking range (1 day).");
                return false;
            }

            bookingDao.createBooking(meetingRoomId, bookedBy, startTime, endTime);
            System.out.println("Booking successful!");
            return true;
        } finally {
            lockService.releaseLock(meetingRoomId);
        }
    }
}