package utls;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MenuUtils {
    public static Integer getUserChooseAsNumber() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (NoSuchElementException |
                NumberFormatException |
                IllegalStateException error) {
            System.out.println("You can use only numbers for selecting!");
        }
        return getUserChooseAsNumber();
    }

    public static void printDivider() {
        System.out.println("|===================================|");
    }

    public static void waitForEnter() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printPrompt() {
        System.out.print(">: ");
    }

    public static void printOption(Integer optionNumber, String option) {
        System.out.println(optionNumber + " - " + option);
    }

    public static void printOptions(Enum[] commandOptions) {
        printDivider();

        IntStream.
                range(0, commandOptions.length)
                .forEach(optionIndex -> printOption(optionIndex, commandOptions[optionIndex].toString()));
        printDivider();
        printPrompt();
    }

    public static Enum selectedCommand(Enum[] allOptions) {
        Integer choose = getUserChooseAsNumber();
        if (allOptions.length <= choose) {
            System.out.println("No switch command!");
            return selectedCommand(allOptions);
        }
        return allOptions[choose];
    }

    public static long getLong() {
        long number;
        Scanner scanner = new Scanner(System.in);
        try {
            printPrompt();
            number = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("It's not a valid number. Please, try again:");
            return getLong();
        }

        return number;
    }
}
