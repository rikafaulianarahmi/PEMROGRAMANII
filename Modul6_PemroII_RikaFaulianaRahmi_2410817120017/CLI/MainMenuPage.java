package CLI;

import java.util.ArrayList;
import java.util.List;

class MainMenuPage extends BasePage {
    private List<MenuItem> menuItems;

    private interface Command { void execute(); }

    // Command Concrete untuk navigasi
    private class NavigateCommand implements Command {
        private PageNavigator nav; private String key;
        public NavigateCommand(PageNavigator nav, String key) { this.nav = nav; this.key = key; }
        @Override public void execute() { nav.navigateTo(key); }
    }

    // Command Concrete untuk keluar aplikasi
    private class ExitAppCommand implements Command {
        private OutputHandler out;
        public ExitAppCommand(OutputHandler out) { this.out = out; }
        @Override public void execute() {
            out.println("\nThank you for using the application!");
            exitFlag = true;
        }
    }

    // Helper Class untuk MenuItem
    private static class MenuItem {
        String label;
        Command command;
        public MenuItem(String label, Command command) {
            this.label = label;
            this.command = command;
        }
    }

    public MainMenuPage(InputHandler inputHandler, OutputHandler outputHandler, PageNavigator navigator) {
        super(inputHandler, outputHandler);
        this.menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("User Input Page", new NavigateCommand(navigator, "input")));
        menuItems.add(new MenuItem("Display Information", new NavigateCommand(navigator, "display")));
        menuItems.add(new MenuItem("Exit", new ExitAppCommand(outputHandler)));
    }

    @Override
    public void display() {
        displayHeader("MAIN MENU");
        int index = 1;
        for (MenuItem item : menuItems) {
            outputHandler.println(index + ". " + item.label);
            index++;
        }
        outputHandler.print("\nSelect option: ");
    }

    @Override
    public void handleInput() {
        int choice = inputHandler.readInt();
        if (choice >= 1 && choice <= menuItems.size()) {
            menuItems.get(choice - 1).command.execute();
        } else {
            outputHandler.println("\nInvalid option. Please try again.");
        }
    }
}