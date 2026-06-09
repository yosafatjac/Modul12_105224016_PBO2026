public class CreditCardPayment implements RefundablePaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran kartu kredit sebesar Rp" + amount + " berhasil diproses.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund kartu kredit sebesar Rp" + amount + " berhasil diproses.");
    }
}