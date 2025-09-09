package org.example.enumExample;

// 주문 상태를 표현하는 열거형
enum OrderStatus {
    ORDERED,     // 주문 완료
    SHIPPED,     // 배송 중
    DELIVERED,   // 배송 완료
    CANCELED     // 주문 취소
}

class Order {
    private int id;
    private OrderStatus status;

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.ORDERED; // 기본 상태는 주문 완료
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void printStatus() {
        System.out.println("주문번호 " + id + "의 상태: " + status);
    }
}

public class EnumOrderExample {
    public static void main(String[] args) {
        Order order = new Order(1001);
        order.printStatus(); // 주문 완료

        order.setStatus(OrderStatus.SHIPPED);
        order.printStatus(); // 배송 중

        order.setStatus(OrderStatus.DELIVERED);
        order.printStatus(); // 배송 완료
    }
}
