public class OrderService {
    private OrderRepository orderRepository;
    private PaymentMethod paymentMethod;
    private EmailNotifier emailNotifier;

    public OrderService(OrderRepository orderRepository,
                        PaymentMethod paymentMethod,
                        EmailNotifier emailNotifier) {
        this.orderRepository = orderRepository;
        this.paymentMethod = paymentMethod;
        this.emailNotifier = emailNotifier;
    }

    public void processOrder(Order order) {
        orderRepository.save(order);
        paymentMethod.pay(order.getAmount());

        emailNotifier.sendEmail(
                "Resi pesanan " + order.getOrderId()
                + " untuk " + order.getCustomerName()
                + " berhasil dikirim."
        );
    }
}