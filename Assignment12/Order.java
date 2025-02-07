package Assignment12;

public class Order {

    private int orderId;
    private String orderDate;

    Order(int orderId,String orderDate){
        this.orderId=orderId;
        this.orderDate=orderDate;

    }

    void getOrderStatus() {
        System.out.println("Order Id: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }

}

class ShippedOrder extends Order {

    private int trackingNumber;

    ShippedOrder(int orderId, String orderDate,int trackingNumber){
        super(orderId,orderDate);
        this.trackingNumber=trackingNumber;
    }

    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Tracking Number: " + trackingNumber);
    }

}

class DeliveredOrder extends ShippedOrder {

    private int deliveryDate;

    DeliveredOrder(int orderId,String orderDate,int trackingNumber,int deliveryDate){
        super(orderId,orderDate,trackingNumber);
        this.deliveryDate=deliveryDate;
    }

    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Delivery Date: " + deliveryDate);

    }

}
