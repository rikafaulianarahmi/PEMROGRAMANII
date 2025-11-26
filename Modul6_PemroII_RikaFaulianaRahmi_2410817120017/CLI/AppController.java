package CLI;

class AppController {
    private PageNavigator navigator;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private DataStore dataStore;

    public AppController() {
        this.inputHandler = new ConsoleInputHandler();
        this.outputHandler = new ConsoleOutputHandler();
        this.dataStore = new DataStore();
        this.navigator = new PageNavigator();

        initializePages();
    }

    private void initializePages() {
        MainMenuPage mainMenu = new MainMenuPage(inputHandler, outputHandler, navigator);
        UserInputPage inputPage = new UserInputPage(inputHandler, outputHandler, dataStore);
        DisplayInfoPage displayPage = new DisplayInfoPage(inputHandler, outputHandler, dataStore);

        navigator.registerPage("main", mainMenu);
        navigator.registerPage("input", inputPage);
        navigator.registerPage("display", displayPage);
    }

    public void run() {
        outputHandler.println("Welcome to CLI Application!");

        while (true) {
            Page currentPage = navigator.getCurrentPage();
            currentPage.display();
            currentPage.handleInput();

            if (currentPage.shouldExit()) {
                if (navigator.getCurrentPageKey().equals("main")) {
                    break;
                } else {
                    navigator.navigateTo("main");
                }
            }
        }
    }
}

