package CLI;

class DisplayInfoPage extends BasePage {
    private DataStore dataStore;

    public DisplayInfoPage(InputHandler inputHandler, OutputHandler outputHandler, DataStore dataStore) {
        super(inputHandler, outputHandler);
        this.dataStore = dataStore;
    }

    @Override
    public void display() {
        displayHeader("STORED DATA");

        if (dataStore.isEmpty()) {
            outputHandler.println("No data available.");
        } else {
            outputHandler.println("Your saved data:");
            int index = 1;
            for (String data : dataStore.getAllData()) {
                outputHandler.println(index + ". " + data);
                index++;
            }
        }

        outputHandler.println("\nType 'back' to return to main menu");
        outputHandler.print("\nInput: ");
    }

    @Override
    public void handleInput() {
        String input = inputHandler.readLine();
        if (input.equalsIgnoreCase("back")) {
            exitFlag = true;
        }
    }
}
