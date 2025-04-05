package src;

import java.util.Map;
import java.util.HashMap;

// Tương ứng với mỗi địa chỉ sẽ có một danh sách các đơn hàng
// Tương ứng với mỗi mã đơn hàng sẽ có một danh sách các sản phẩm
public class MergeOrder {
    private String address;
    private Map<String, String> orderId_products = new HashMap<>();

    public MergeOrder(String address) {
        this.address = address;
    }

    public void addOrder(Order order) {
        orderId_products.put(order.getOrderId(), String.join(", ", order.getProducts()));
    }

    public void info() {
        System.out.println("Address: " + address);
        orderId_products.forEach((orderId, products) -> 
            System.out.println("Order ID: " + orderId + ", Products: " + products)
        );
    }

}
