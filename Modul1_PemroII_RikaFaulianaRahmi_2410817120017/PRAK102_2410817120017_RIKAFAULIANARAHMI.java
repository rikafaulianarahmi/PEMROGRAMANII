import java.util.Scanner;

public class PRAK102_2410817120017_RIKAFAULIANARAHMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = scanner.nextInt();

        int counter = 0;
        int currentNumber = startNumber;

        while (counter < 11) {
            if (currentNumber % 5 == 0) {
                int result = (currentNumber / 5) - 1;
                System.out.print(result);
            } else {
                System.out.print(currentNumber);
            }

            if (counter < 10) {
                System.out.print(",");
            }

            currentNumber++;
            counter++;
        }

        scanner.close();
    }
}