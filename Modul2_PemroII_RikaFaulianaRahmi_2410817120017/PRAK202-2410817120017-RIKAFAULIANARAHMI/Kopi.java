package praktikum2.soal2;

public class Kopi {
    public String namaKopi;
    public String ukuran;
    public double harga;
    private String buyer;

    public void info() {
        System.out.println("Nama Kopi: " + this.namaKopi);
        System.out.println("Ukuran: " + this.ukuran);
        System.out.println("Harga: Rp. " + this.harga);
    }

    public void setPembeli(String newBuyer) {
        this.buyer = newBuyer;
    }

    public String getPembeli() {
        return this.buyer;
    }

    public double getPajak() {
        // Pajak 11% dari harga
        double tax = this.harga * 0.11;
        return tax;
    }
}