package src;
import java.util.List;
public class Order {
    private String orderId;
    private String address;
    private List<String> products;

    public Order(String orderId, String address, List<String> products) {
        this.orderId = orderId;
        this.address = address;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getProducts() {
        return products;
    }
    @Override
    public String toString() {
        return "Order" + orderId + ", Address: " + address + ", Products: " + String.join(", ", products);
    }
    
}
