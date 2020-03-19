package menu.commands.person.CRUD;


import menu.Command;
import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import menu.commands.person.PersonCommand;
import models.Person;
import repositories.PersonRepository;

import java.util.Scanner;

public class CreatePersonCommand implements Command {

    private static CreatePersonCommand instance;

    private CreatePersonCommand() {
    }

    public static synchronized CreatePersonCommand getInstance() {
        if (instance == null) {
            instance = new CreatePersonCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        Scanner scanner = new Scanner(System.in);

        Person person = Person
                .websiteBuilder()
                .setFirstName(PersonCommandsUtils.getFirstName(scanner))
                .setLastName(PersonCommandsUtils.getLastName(scanner))
                .setAge(PersonCommandsUtils.getAge(scanner))
                .setEmail(PersonCommandsUtils.getEmail(scanner))
                .setPhone(PersonCommandsUtils.getPhone(scanner))
                .setGender(PersonCommandsUtils.getGender(scanner))
                .build();

        PersonRepository
                .getInstance()
                .add(person);

        return PersonCommand.getInstance();
    }
}
