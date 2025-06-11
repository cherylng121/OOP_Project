import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
        // Create default admin
        Admin admin = new Admin("A001", "Admin");
        users.put(admin.getUserId(), admin);
    }

    public boolean addUser(String userId, String name, String role) {
        if (users.containsKey(userId)) {
            return false;
        }

        User newUser;
        if (role.equalsIgnoreCase("Admin")) {
            newUser = new Admin(userId, name);
        } else {
            newUser = new Customer(userId, name);
        }

        users.put(userId, newUser);
        return true;
    }

    public boolean deleteUser(String userId) {
        if (userId.equals("A001")) {
            return false; // Cannot delete default admin
        }
        return users.remove(userId) != null;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public User authenticateUser(String userId, String name) {
        User user = users.get(userId);
        if (user != null && user.getName().equals(name)) {
            return user;
        }
        return null;
    }

    public void displayAllUsers() {
        System.out.println("\n=== All Users ===");
        for (User user : users.values()) {
            System.out.println("ID: " + user.getUserId() + ", Name: " + user.getName());
            user.displayRole();
        }
    }
} 