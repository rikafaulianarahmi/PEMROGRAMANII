package CLI;

class UserInputPage extends BasePage {
    private DataStore dataStore;

    public UserInputPage(InputHandler inputHandler, OutputHandler outputHandler, DataStore dataStore) {
        super(inputHandler, outputHandler);
        this.dataStore = dataStore;
    }

    @Override
    public void display() {
        displayHeader("USER INPUT");
        outputHandler.println("Enter your data (type 'back' to return to main menu)");
        outputHandler.print("\nYour input: ");
    }

    @Override
    public void handleInput() {
        String input = inputHandler.readLine();

        if (input.equalsIgnoreCase("back")) {
            exitFlag = true;
        } else {
            dataStore.addData(input);
            outputHandler.println("\nData saved successfully!");
            outputHandler.print("\nPress Enter to continue...");
            inputHandler.readLine();
        }
    }
}
