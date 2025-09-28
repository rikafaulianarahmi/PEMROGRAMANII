import java.util.Scanner;

public class PRAK104_2410817120017_RIKAFAULIANARAHMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] abuChoices = new String[3];
        String[] bagasChoices = new String[3];

        System.out.print("Tangan Abu: ");
        for (int i = 0; i < 3; i++) {
            abuChoices[i] = scanner.next();
        }

        System.out.print("Tangan Bagas: ");
        for (int i = 0; i < 3; i++) {
            bagasChoices[i] = scanner.next();
        }

        int abuScore = 0;
        int bagasScore = 0;

        for (int i = 0; i < 3; i++) {
            String abu = abuChoices[i];
            String bagas = bagasChoices[i];

            if ((abu.equals("B") && bagas.equals("G")) ||
                    (abu.equals("G") && bagas.equals("K")) ||
                    (abu.equals("K") && bagas.equals("B"))) {
                abuScore++;
            } else if ((bagas.equals("B") && abu.equals("G")) ||
                    (bagas.equals("G") && abu.equals("K")) ||
                    (bagas.equals("K") && abu.equals("B"))) {
                bagasScore++;
            }
        }

        if (abuScore > bagasScore) {
            System.out.println("Abu");
        } else if (bagasScore > abuScore) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

        scanner.close();
    }
}