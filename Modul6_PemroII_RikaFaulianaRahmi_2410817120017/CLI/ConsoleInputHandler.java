package CLI;

class ConsoleInputHandler implements InputHandler {
    private java.util.Scanner scanner;

    public ConsoleInputHandler() {
        this.scanner = new java.util.Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
