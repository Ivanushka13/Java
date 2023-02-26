package davydoff.console;

import java.util.Scanner;

/**
 * Class-controller for the console input.
 * It has only one method that checks the input from console.
 */
public final class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getFieldName() {
        String input = scanner.nextLine().trim();
        while (input.contains(" ") || input.isEmpty()) {
            OutputHandler.printWrongInputError();
            input = scanner.nextLine().trim();
        }
        return input;
    }
}
