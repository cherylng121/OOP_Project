public class Customer extends User {
    public Customer(String userId, String name) {
        super(userId, name);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
    }
} 