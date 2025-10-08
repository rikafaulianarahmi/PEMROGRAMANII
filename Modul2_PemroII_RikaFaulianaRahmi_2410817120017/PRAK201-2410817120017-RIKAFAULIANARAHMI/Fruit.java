package Praktikum2.Soal1;

public class Fruit {
    String name;
    double price;
    double weight;
    double totalBuy;
    final double discount = 0.02;
    final double multidisc = 4.0;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setTotalBuy(double totalBuy) {
        this.totalBuy = totalBuy;
    }
    public double getTotalBuy() {
        return totalBuy;
    }

    public double getPriceKg() {
        return getPrice() / getWeight();
    }

    public double getbeforeDisc() {
        return getTotalBuy() * getPriceKg();
    }

    public double getCalculatedDisc() {
        double totaldiscount = (int)(totalBuy / multidisc) * (multidisc * price) * discount;
        return totaldiscount;
    }
    public double getAfterDisc() {
        return getbeforeDisc() - getCalculatedDisc();
    }

    public void show() {
        System.out.println("Nama Buah: " + getName());
        System.out.println("Berat: " + getWeight());
        System.out.printf("Harga: %.1f%n", getPrice());
        System.out.printf("Jumlah Beli: %.1fkg%n", getTotalBuy());

        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", getbeforeDisc());
        System.out.printf("Total Diskon: Rp%.2f%n", getCalculatedDisc());
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", getAfterDisc());
        System.out.println(" ");
    }
}
