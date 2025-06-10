import java.util.*;

public class Branch {
    private String name;
    private List<SmartRoom> rooms;

    public Branch(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(SmartRoom room) {
        rooms.add(room);
    }

    public String getName() {
        return name;
    }

    public List<SmartRoom> getAvailableRooms(String type, LocalDate date, LocalTime time) {
        List<SmartRoom> result = new ArrayList<>();
        for (SmartRoom room : rooms) {
            if (room.getType().equalsIgnoreCase(type) && room.getSchedule().isAvailable(date, time)) {
                result.add(room);
            }
        }
        return result;
    }

    public SmartRoom getRoomById(String id) {
        for (SmartRoom room : rooms) {
            if (room.getRoomId().equals(id)) return room;
        }
        return null;
    }
}
