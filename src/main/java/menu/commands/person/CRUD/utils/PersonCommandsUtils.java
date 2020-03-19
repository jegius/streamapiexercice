package menu.commands.person.CRUD.utils;

import menu.Command;
import menu.commands.person.PersonCommand;
import models.Gender;
import models.Person;
import repositories.PersonRepository;
import utls.MenuUtils;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class PersonCommandsUtils {

    public static String getFirstName(Scanner scanner) {
        return getUserInput(scanner, "Enter person first name: ", "First name can't be empty");
    }

    public static String getLastName(Scanner scanner) {
        return getUserInput(scanner, "Enter person last name: ", "Last name can't be empty");
    }

    public static Long getAge(Scanner scanner) {
        try {
            return Long.parseLong(getUserInput(scanner, "Enter person age: ", "Age can't be empty"));
        } catch (Exception e) {
            System.out.println("Age should be a number!");
            return getAge(scanner);
        }
    }

    public static String getEmail(Scanner scanner) {
        return getUserInput(scanner, "Enter person email: ", "Email can't be empty");
    }


    public static String getPhone(Scanner scanner) {
        return getUserInput(scanner, "Phone person phone: ", "Phone can't be empty");
    }

    public static Gender getGender(Scanner scanner) {
        System.out.println("Is male? Enter 1 for male and other for female.");
        String input = scanner.nextLine();

        if (Pattern.matches("1", input)) {
            return Gender.MALE;
        }
        return Gender.FEMALE;
    }

    public static boolean printWebsites() {
        MenuUtils.printDivider();
        List<Person> people = PersonRepository
                .getInstance()
                .get();

        if (people.isEmpty()) {
            System.out.println("No person have been found");
            MenuUtils.waitForEnter();
            return false;
        }

        people.forEach(PersonCommandsUtils::printWebsites);

        MenuUtils.printDivider();

        return true;
    }

    public static Command checkWebsiteExistingAndDoCustomAction(Command command, DoCustomAction customAction) {
        MenuUtils.printDivider();
        System.out.println("Please select person from this options: ");

        if (!printWebsites()) {
            return PersonCommand.getInstance();
        }

        Person website = PersonRepository
                .getInstance()
                .getById(MenuUtils.getLong());

        if (website == null) {
            MenuUtils.printDivider();
            System.out.println("Not found person with provided id!");
            MenuUtils.waitForEnter();
            return command;
        }

        customAction.doAction(website);

        return PersonCommand.getInstance();
    }

    private static void printWebsites(Person person) {
        System.out.println(
                person.getId() +
                        " |: " + person.getLastName() +
                        " - " + person.getFirstName()
        );
    }

    private static String getUserInput(Scanner scanner, String success, String invalid) {
        MenuUtils.printDivider();
        System.out.println(success);
        MenuUtils.printPrompt();

        String input = scanner.nextLine();

        if (input.isEmpty()) {
            MenuUtils.printDivider();
            System.out.println(invalid);
            input = getUserInput(scanner, success, invalid);
        }

        return input;
    }
}
