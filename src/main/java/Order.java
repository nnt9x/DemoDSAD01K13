import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String orderDate;
    private String customerName;
    private String customerPhone;
    private int totalAmount;
    private List<OrderItem> itemList;
    private boolean status; // false- chua duyet, true- da duyet

    public Order() {
        itemList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void calculateTotalAmount() {
        // Tinh va set total amount
        for (OrderItem o: itemList) {
            this.totalAmount += o.getProduct().getPrice() * o.getQuantity();
        }
    }



    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    // Print order
    public void printOrder(){
        System.out.println("Order: "+ id);
        System.out.printf("Customer: [%s - %s ]\n", customerName, customerPhone);
        System.out.println("TotalAmount: "+totalAmount);
        System.out.println("Status: " + (status ? "Approved" : "Pending"));
        // San pham da dat
        System.out.println("ID - Product Name - Price - Quantity - Amount");
        System.out.println("-------------------------------------------------");
        for (OrderItem orderItem: itemList) {
           // Ma san pham - Ten san pham - Gia - So luong - Thanh tien
            System.out.print(orderItem.getProduct().getId() +"\t");
            System.out.print(orderItem.getProduct().getName() +"\t");
            System.out.print(orderItem.getProduct().getPrice()+"\t");
            System.out.print(orderItem.getQuantity()+"\t");
            System.out.print(orderItem.getProduct().getPrice() * orderItem.getQuantity());
            System.out.println();
        }

        System.out.println("-------------------------------------------------");
    }
}
