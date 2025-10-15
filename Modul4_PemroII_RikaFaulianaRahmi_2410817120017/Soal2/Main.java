package Soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Nama hewan peliharaan: ");
            String name = scanner.nextLine();
            System.out.print("Ras: ");
            String breed = scanner.nextLine();
            System.out.print("Warna Bulu: ");
            String furColor = scanner.nextLine();

            Cat cat = new Cat(name, breed, furColor);
            System.out.println();
            cat.displayDetail();
        }
        else if (choice == 2) {
            System.out.print("Nama hewan peliharaan: ");
            String name = scanner.nextLine();
            System.out.print("Ras: ");
            String breed = scanner.nextLine();
            System.out.print("Warna Bulu: ");
            String furColor = scanner.nextLine();
            System.out.print("Kemampuan : ");
            String abilitiesInput = scanner.nextLine();

            // Split abilities with comma and space
            String[] abilities = abilitiesInput.split(", ");

            Dog dog = new Dog(name, breed, furColor, abilities);
            System.out.println();
            dog.displayDetail();
        }

        scanner.close();
    }
}