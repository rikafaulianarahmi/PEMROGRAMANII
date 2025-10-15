package Soal2;

public class Cat extends Pet {
    private String furColor;

    public Cat(String name, String breed, String furColor) {
        super(name, breed);
        this.furColor = furColor;
    }

    public void displayDetail() {
        super.display();
        System.out.println("Memiliki warna bulu : " + furColor);
    }
}