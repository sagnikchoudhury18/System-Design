public class MeetingRoom {
    private long id;
    private String name;
    private int capacity;
    private String infraAvailability;

    public MeetingRoom(long id, String name, int capacity, String infraAvailability) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.infraAvailability = infraAvailability;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getInfraAvailability() {
        return infraAvailability;
    }
}