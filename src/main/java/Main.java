import java.util.PrimitiveIterator;

public class Main {
    public static void main(String[] args) {
        // Tao hang doi: chua toi 100 hoa don
        QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);

        // Tao san pham (tao san)
        Product product1 = new Product(1, "Product 1", 1000);
        Product product2 = new Product(2, "Product 2", 2000);
        // Tao hoa don, di kem tao hoa don chi tiet
        Order order1 = new Order();
        order1.setId(1);
        order1.setStatus(false);
        order1.setOrderDate("2023-11-08");
        order1.setCustomerName("Customer 1");
        order1.setCustomerPhone("123455");
        // Can tao hoa don chi tiet
        order1.getItemList().add(new OrderItem(1, product1, 10));
        order1.getItemList().add(new OrderItem(2, product2, 2));
        // Tinh lai tong tien
        order1.calculateTotalAmount();

        //
        Order order2 = new Order();
        order2.setId(3);
        order2.setStatus(false);
        order2.setOrderDate("2023-11-08");
        order2.setCustomerName("Customer 2");
        order2.setCustomerPhone("1234554");
        // Can tao hoa don chi tiet
        order2.getItemList().add(new OrderItem(1, product1, 2));
        order2.getItemList().add(new OrderItem(2, product2, 10));
        // Tinh lai tong tien
        order1.calculateTotalAmount();

        // Hoa don se duoc dua vao hang doi
        orderQueueADT.enqueue(order2);
        orderQueueADT.enqueue(order1);

        // Xu ly -> dung dequeue -> lan luot lay ra
        while (!orderQueueADT.isEmpty()){
            Order o = orderQueueADT.dequeue();
            o.setStatus(true);
            o.printOrder();
        }
        // Xu ly xong
    }
}
