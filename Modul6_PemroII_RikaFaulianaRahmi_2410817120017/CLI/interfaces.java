package CLI;

interface InputHandler {
    String readLine();
    int readInt();
}

interface OutputHandler {
    void print(String message);
    void println(String message);
    void clear();
}

interface Page {
    void display();
    void handleInput();
    boolean shouldExit();
}
