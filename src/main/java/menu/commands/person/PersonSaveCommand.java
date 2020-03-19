package menu.commands.person;

import menu.Command;
import repositories.PersonRepository;
import utls.MenuUtils;

public class PersonSaveCommand implements Command {
    private static PersonSaveCommand instance;

    private PersonSaveCommand() {
    }

    public static synchronized PersonSaveCommand getInstance() {
        if (instance == null) {
            instance = new PersonSaveCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        PersonRepository
                .getInstance()
                .save();

        System.out.println("All repository entry saved successful!");
        MenuUtils.waitForEnter();

        return PersonCommand.getInstance();
    }
}
