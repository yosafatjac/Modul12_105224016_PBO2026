public class OVOPayment implements RefundablePaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran OVO sebesar Rp" + amount + " berhasil diproses.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund OVO sebesar Rp" + amount + " berhasil diproses.");
    }
}