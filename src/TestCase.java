package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TestCase {
    // Hướng 1: Sử dụng Hashmap
    public static List<MergeOrder> mergeOrder1(List<Order> orders) {
        Map<String, MergeOrder> mergeOrderMap = new HashMap<>();
        orders.forEach(order -> {
            // Kiểm tra nếu địa chỉ đã tồn tại trong map thì gộp đơn hàng vào địa chỉ đó
            if (mergeOrderMap.containsKey(order.getAddress()))
                mergeOrderMap.get(order.getAddress()).addOrder(order);
            else {
                // Nếu địa chỉ chưa tồn tại thì tạo mới một MergeOrder và thêm đơn hàng vào
                MergeOrder mergeOrder = new MergeOrder(order.getAddress());
                mergeOrder.addOrder(order);
                mergeOrderMap.put(order.getAddress(), mergeOrder);
            }
        });
        // Trả về danh sách những đơn hàng đã được gộp theo địa chỉ
        return new ArrayList<>(mergeOrderMap.values());
    }

    // Hướng 2: Sử dụng List
    public static List<MergeOrder> mergeOrder2(List<Order> orders) {
        List<MergeOrder> mergeOrderList = new ArrayList<>();
        // Sắp xếp danh sách theo địa chỉ tăng dần để các đơn hàng cùng địa chỉ nằm cạnh
        // nhau
        orders.sort((o1, o2) -> o1.getAddress().compareTo(o2.getAddress()));
        String currentAddress = "";
        for (Order order : orders) {
            if (!order.getAddress().equals(currentAddress)) {
                // Nếu địa chỉ khác với currentAddress thì tạo mới một MergeOrder và thêm đơn
                // hàng vào
                // Cập nhật currentAddress

                currentAddress = order.getAddress();
                MergeOrder mergeOrder = new MergeOrder(currentAddress);
                mergeOrder.addOrder(order);
                mergeOrderList.add(mergeOrder);
            } else
                // Nếu địa chỉ giống với currentAddress thì gộp đơn hàng vào MergeOrder hiện tại
                mergeOrderList.get(mergeOrderList.size() - 1).addOrder(order);
        }

        return mergeOrderList;
    }

    // Test case 1: Các đơn hàng có địa chỉ giống nhau
    public static void sameAddress() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Ha Noi", List.of("San pham A", "San pham B")));
        orders.add(new Order("2", "Ha Noi", List.of("San pham C")));
        orders.add(new Order("3", "Ha Noi", List.of("San pham D")));
        System.out.println("Thong tin don hang truoc khi gop:");
        orders.forEach(System.out::println); // method reference
        System.out.println();
        System.out.println("Thong tin don hang sau khi gop:");
        System.out.println("Huong 1:");
        mergeOrder1(orders).forEach(i -> i.info());
        System.out.println("Huong 2:");
        mergeOrder2(orders).forEach(i -> i.info());
    }

    // Test case 2: Các đơn hàng có địa chỉ khác nhau
    public static void differentAddress() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Ha Noi", List.of("San pham A", "San pham B")));
        orders.add(new Order("2", "Da Nang", List.of("San pham C")));
        orders.add(new Order("3", "Hai Phong", List.of("San pham D")));
        System.out.println("Thong tin don hang truoc khi gop:");
        orders.forEach(System.out::println);
        System.out.println();
        System.out.println("Thong tin don hang sau khi gop:");
        System.out.println("Huong 1:");
        mergeOrder1(orders).forEach(i -> i.info());
        System.out.println("Huong 2:");
        mergeOrder2(orders).forEach(i -> i.info());
    }

    // Test case 3: Các đơn hàng có địa chỉ giống nhau và khác nhau
    public static void sameAndDifferentAddress() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Ha Noi", List.of("San pham A", "San pham B")));
        orders.add(new Order("2", "Da Nang", List.of("San pham C")));
        orders.add(new Order("3", "Hai Phong", List.of("San pham D")));
        orders.add(new Order("4", "Ha Noi", List.of("San pham E")));
        orders.add(new Order("5", "Da Nang", List.of("San pham F")));
        System.out.println("Thong tin don hang truoc khi gop:");
        orders.forEach(System.out::println);
        System.out.println();
        System.out.println("Thong tin don hang sau khi gop:");
        System.out.println("Huong 1:");
        mergeOrder1(orders).forEach(i -> i.info());
        System.out.println("Huong 2:");
        mergeOrder2(orders).forEach(i -> i.info());
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: Don hang co dia chi giong nhau");
        sameAddress();
        System.out.println("\n\n");
        System.out.println("Test case 2: Don hang co dia chi khac nhau");
        differentAddress();
        System.out.println("\n\n");
        System.out.println("Test case 3: Don hang co dia chi giong nhau va khac nhau");
        sameAndDifferentAddress();
    }
}
