package Soal2;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Country> countryList = new LinkedList<>();

        HashMap<Integer, String> monthNames = new HashMap<>();
        monthNames.put(1, "Januari");
        monthNames.put(2, "Februari");
        monthNames.put(3, "Maret");
        monthNames.put(4, "April");
        monthNames.put(5, "Mei");
        monthNames.put(6, "Juni");
        monthNames.put(7, "Juli");
        monthNames.put(8, "Agustus");
        monthNames.put(9, "September");
        monthNames.put(10, "Oktober");
        monthNames.put(11, "November");
        monthNames.put(12, "Desember");

        int numberOfCountries = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCountries; i++) {
            String name = scanner.nextLine();
            String leadershipType = scanner.nextLine();
            String leaderName = scanner.nextLine();

            Country country;
            if (leadershipType.equalsIgnoreCase("monarki")) {
                country = new Country(name, leadershipType, leaderName);
            } else {
                int date = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                scanner.nextLine();
                country = new Country(name, leadershipType, leaderName, date, month, year);
            }
            countryList.add(country);
        }

        for (int i = 0; i < countryList.size(); i++) {
            Country country = countryList.get(i);
            String title = "";

            if (country.getLeadershipType().equalsIgnoreCase("monarki")) {
                title = "Raja";
            } else if (country.getLeadershipType().equalsIgnoreCase("presiden")) {
                title = "Presiden";
            } else if (country.getLeadershipType().equalsIgnoreCase("perdana menteri")) {
                title = "Perdana Menteri";
            } else {
                title = country.getLeadershipType();
            }

            System.out.println("Negara " + country.getName() + " mempunyai " +
                    title + " bernama " + country.getLeaderName());

            if (!country.getLeadershipType().equalsIgnoreCase("monarki")) {
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " +
                        country.getIndependenceDate() + " " +
                        monthNames.get(country.getIndependenceMonth()) + " " +
                        country.getIndependenceYear());
            }

            if (i < countryList.size() - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }
}