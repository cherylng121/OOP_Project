import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RoomSchedule {
    private Map<LocalDate, List<LocalTime>> schedule = new HashMap<>();

    public boolean isAvailable(LocalDate date, LocalTime time) {
        List<LocalTime> bookedSlots = schedule.getOrDefault(date, new ArrayList<>());
        return !bookedSlots.contains(time);
    }

    public void bookSlot(LocalDate date, LocalTime time) {
        schedule.computeIfAbsent(date, d -> new ArrayList<>()).add(time);
    }

    public void displaySchedule() {
        for (Map.Entry<LocalDate, List<LocalTime>> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}