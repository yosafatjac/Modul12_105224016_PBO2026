public class BankTransferPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran transfer bank sebesar Rp" + amount + " berhasil diproses.");
    }
}