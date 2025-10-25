package Soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String name = input.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = input.nextLine();

                    boolean nimExists = false;
                    for (Student student : studentList) {
                        if (student.getNim().equals(nim)) {
                            nimExists = true;
                            break;
                        }
                    }

                    if (nimExists) {
                        System.out.println("NIM sudah terdaftar. Gunakan NIM yang berbeda.");
                    } else {
                        studentList.add(new Student(name, nim));
                        System.out.println("Mahasiswa " + name + " ditambahkan.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimToDelete = input.nextLine();

                    boolean found = false;
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getNim().equals(nimToDelete)) {
                            studentList.remove(i);
                            System.out.println("Mahasiswa dengan NIM " + nimToDelete + " dihapus.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Mahasiswa dengan NIM " + nimToDelete + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String nimToSearch = input.nextLine();

                    boolean foundStudent = false;
                    for (Student student : studentList) {
                        if (student.getNim().equals(nimToSearch)) {
                            System.out.println("NIM: " + student.getNim() + ", Nama: " + student.getName());
                            foundStudent = true;
                            break;
                        }
                    }

                    if (!foundStudent) {
                        System.out.println("Mahasiswa dengan NIM " + nimToSearch + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    if (studentList.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong.");
                    } else {
                        System.out.println("Daftar Mahasiswa:");
                        for (Student student : studentList) {
                            System.out.println("NIM: " + student.getNim() + ", Nama: " + student.getName());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

            if (running) {
                System.out.println();
            }
        }

        input.close();
    }
}