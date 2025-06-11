import java.time.LocalDate;
import java.time.LocalTime;

public class BookingValidator {
    public static boolean isValidBookingTime(LocalTime time) {
        // Check if time is within business hours (8 AM to 8 PM)
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(20, 0);
        return !time.isBefore(startTime) && !time.isAfter(endTime);
    }

    public static boolean isValidBookingDate(LocalDate date) {
        // Check if date is not in the past
        return !date.isBefore(LocalDate.now());
    }

    public static boolean isRoomAvailable(SmartRoom room, LocalDate date, LocalTime time) {
        return room.getSchedule().isAvailable(date, time);
    }

    public static boolean isValidCapacity(SmartRoom room, int requiredCapacity) {
        return room.getCapacity() >= requiredCapacity;
    }

    public static boolean canUserBook(Customer customer, LocalDate date) {
        // Check if user has reached booking limit for the day
        // This is a placeholder - implement actual logic based on requirements
        return true;
    }
} 