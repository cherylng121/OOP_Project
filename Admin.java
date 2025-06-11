public class Admin extends User {
    public Admin(String userId, String name) {
        super(userId, name);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin");
    }

    public void viewAllBookings(BookingManager manager) {
        System.out.println("\n=== All Bookings ===");
        manager.viewAllBookings();
    }
} 