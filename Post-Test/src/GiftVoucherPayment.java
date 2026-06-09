public class GiftVoucherPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran gift voucher sebesar Rp" + amount + " berhasil digunakan.");
    }
}