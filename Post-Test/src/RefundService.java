public class RefundService {
    private RefundablePaymentMethod refundablePaymentMethod;

    public RefundService(RefundablePaymentMethod refundablePaymentMethod) {
        this.refundablePaymentMethod = refundablePaymentMethod;
    }

    public void processRefund(double amount) {
        refundablePaymentMethod.refund(amount);
    }
}