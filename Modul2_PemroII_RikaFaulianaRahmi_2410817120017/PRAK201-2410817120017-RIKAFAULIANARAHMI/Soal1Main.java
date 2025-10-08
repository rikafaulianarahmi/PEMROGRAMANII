package Praktikum2.Soal1;

public class Soal1Main {
    public static void main(String[] args){
        Fruit apple = new Fruit();
        apple.setName("apel");
        apple.setWeight(0.4);
        apple.setPrice(7000.0);
        apple.setTotalBuy(40);
        apple.show();

        Fruit mango = new Fruit();
        mango.setName("mangga");
        mango.setWeight(0.2);
        mango.setPrice(3500.0);
        mango.setTotalBuy(15);
        mango.show();

        Fruit avocado = new Fruit();
        avocado.setName("alpukat");
        avocado.setWeight(0.25);
        avocado.setPrice(10000.0);
        avocado.setTotalBuy(12);
        avocado.show();
    }
}
