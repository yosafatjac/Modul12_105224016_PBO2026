public class Main {
    public static void main(String[] args) {
        Order order = new Order("ORD001", "Yosafat", 150000);

        OrderRepository orderRepository = new InMemoryOrderRepository();
        PaymentMethod paymentMethod = new GiftVoucherPayment();
        EmailNotifier emailNotifier = new EmailSystem();

        OrderService orderService = new OrderService(
                orderRepository,
                paymentMethod,
                emailNotifier
        );

        orderService.processOrder(order);

        RefundablePaymentMethod creditCard = new CreditCardPayment();
        RefundService refundService = new RefundService(creditCard);
        refundService.processRefund(50000);
    }
}