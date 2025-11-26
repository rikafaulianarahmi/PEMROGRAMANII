package CLI;

abstract class BasePage implements Page {
    protected InputHandler inputHandler;
    protected OutputHandler outputHandler;
    protected boolean exitFlag;

    public BasePage(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.exitFlag = false;
    }

    @Override
    public boolean shouldExit() {
        return exitFlag;
    }

    protected void displayHeader(String title) {
        outputHandler.println("\n=================================");
        outputHandler.println("  " + title);
        outputHandler.println("=================================");
    }
}
