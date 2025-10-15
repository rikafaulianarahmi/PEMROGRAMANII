package Soal2;

public class Pet {
    protected String name;
    protected String breed;

    public Pet(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + name);
        System.out.println("Dengan ras : " + breed);
    }
}