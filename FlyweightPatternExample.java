import java.util.HashMap;
import java.util.Map;

// Flyweight class representing shared properties (Intrinsic State)
class OrderFlyweight {
    private String menu; // Intrinsic state
    private int tableNumber; // Intrinsic state

    // Constructor initializes intrinsic state
    public OrderFlyweight(String menu, int tableNumber) {
        this.menu = menu;
        this.tableNumber = tableNumber;
    }

    // Display method uses both intrinsic and extrinsic state
    public void serveOrder(String takeOrder, double bill) {
        System.out.println("Menu: " + menu + " | Table: " + tableNumber + " | Order: " + takeOrder + " | Bill: Rs " + bill);
    }
}

// FlyweightFactory to manage the Flyweights and reuse objects
class OrderFlyweightFactory {
    private Map<String, OrderFlyweight> flyweightPool;

    // Constructor initializes the flyweight pool
    public OrderFlyweightFactory() {
        flyweightPool = new HashMap<>();
    }

    // Get or create Flyweight based on intrinsic state (menu + table number)
    public OrderFlyweight getFlyweight(String menu, int tableNumber) {
        String key = menu + "-" + tableNumber;  // Unique key combining menu and table number
        if (!flyweightPool.containsKey(key)) {
            flyweightPool.put(key, new OrderFlyweight(menu, tableNumber));
        }
        return flyweightPool.get(key);
    }
}

// Client code to demonstrate the Flyweight pattern
public class FlyweightPatternExample {
    public static void main(String[] args) {
        // Create a factory for managing Flyweights
        OrderFlyweightFactory factory = new OrderFlyweightFactory();

        // Reuse Flyweight objects for common menu and table number combinations
        OrderFlyweight order1 = factory.getFlyweight("Punjabi Menu", 1); 
        OrderFlyweight order2 = factory.getFlyweight("Gujarati Menu", 2);
        OrderFlyweight order3 = factory.getFlyweight("Chinese Menu", 1);  // A new flyweight for a different menu and table

        // Use the Flyweights, passing extrinsic state (takeOrder and bill)
        order1.serveOrder("Paneer Makhni", 150.0);  // Take order: Paneer Makhni, Bill: Rs 150.0
        order2.serveOrder("Gujarati Thali", 200.0);  // Take order: Gujarati Thali, Bill: Rs 200.0
        order3.serveOrder("Noodles", 160.0);  // Take order: Noodles, Bill: Rs 160.0 (separate flyweight for Chinese menu)
    }
}
