package menu.commands.person.CRUD;


import menu.Command;
import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import menu.commands.person.PersonCommand;

public class ReadPersonCommand implements Command {

    private static ReadPersonCommand instance;

    private ReadPersonCommand() {}

    public static synchronized ReadPersonCommand getInstance() {
        if (instance == null) {
            instance = new ReadPersonCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        PersonCommandsUtils.printWebsites();
        return PersonCommand.getInstance();
    }
}