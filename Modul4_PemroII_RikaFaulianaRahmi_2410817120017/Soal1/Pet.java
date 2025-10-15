package Soal1;

import java.util.Scanner;

public class Pet {
    private String name;
    private String breed;

    public Pet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Hewan Peliharaan: ");
        this.name = scanner.nextLine();
        System.out.print("Ras: ");
        this.breed = scanner.nextLine();
        System.out.println();
    }

    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + name);
        System.out.println("Dengan ras : " + breed);
    }
}