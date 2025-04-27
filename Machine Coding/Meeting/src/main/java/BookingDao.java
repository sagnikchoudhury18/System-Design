import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    private List<Booking> bookings = new ArrayList<>();
    private long bookingIdCounter = 1;

    public void createBooking(long meetingRoomId, String bookedBy, LocalDateTime startTime, LocalDateTime endTime) {
        Booking booking = new Booking(bookingIdCounter++, meetingRoomId, bookedBy, startTime, endTime);
        bookings.add(booking);
    }

    public List<Booking> getBookingsForRoom(long meetingRoomId) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getMeetingRoomId() == meetingRoomId) {
                result.add(booking);
            }
        }
        return result;
    }
}