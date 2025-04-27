import java.util.HashMap;
import java.util.Map;

public class MeetingRoomDao {
    private Map<Long, MeetingRoom> meetingRooms = new HashMap<>();

    public MeetingRoom getMeetingRoomById(long id) {
        return meetingRooms.get(id);
    }

    public void createMeetingRoom(MeetingRoom room) {
        meetingRooms.put(room.getId(), room);
    }

    public void deleteMeetingRoom(long id) {
        meetingRooms.remove(id);
    }
}