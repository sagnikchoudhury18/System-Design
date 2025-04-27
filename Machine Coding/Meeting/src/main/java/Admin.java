public class Admin extends User {

    private MeetingRoomDao meetingRoomDao;

    public Admin(long id, String name, MeetingRoomDao meetingRoomDao) {
        super(id, name);
        this.meetingRoomDao = meetingRoomDao;
    }

    public void createMeetingRoom(long roomId, String name, int capacity, String infraAvailability) {
        MeetingRoom room = new MeetingRoom(roomId, name, capacity, infraAvailability);
        meetingRoomDao.createMeetingRoom(room);
        System.out.println("Meeting room created: " + name);
    }

    public void deleteMeetingRoom(long roomId) {
        meetingRoomDao.deleteMeetingRoom(roomId);
        System.out.println("Meeting room deleted: " + roomId);
    }
}