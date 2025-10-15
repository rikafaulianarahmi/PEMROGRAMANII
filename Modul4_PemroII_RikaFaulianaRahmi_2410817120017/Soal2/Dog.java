package Soal2;

public class Dog extends Pet {
    private String furColor;
    private String[] abilities;

    public Dog(String name, String breed, String furColor, String[] abilities) {
        super(name, breed);
        this.furColor = furColor;
        this.abilities = abilities;
    }

    public void displayDetail() {
        super.display();
        System.out.println("Memiliki warna bulu : " + furColor);
        System.out.print("Memiliki kemampuan :");
        for (int i = 0; i < abilities.length; i++) {
            System.out.print(" " + abilities[i]);
        }
        System.out.println();
    }
}