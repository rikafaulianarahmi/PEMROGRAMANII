import java.util.Scanner;

public class PRAK103_2410817120017_RIKAFAULIANARAHMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int startNumber = scanner.nextInt();

        int printedCount = 0;
        int currentNumber = startNumber;

        do {
            if (currentNumber % 2 != 0) {
                if (printedCount > 0) {
                    System.out.print(",");
                }

                System.out.print(currentNumber);
                printedCount++;
            }

            currentNumber++;

        } while (printedCount < n);

        scanner.close();
    }
}