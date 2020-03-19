package menu.commands.person;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.ExitCommand;
import menu.commands.person.CRUD.CreatePersonCommand;
import menu.commands.person.CRUD.DeletePersonCommand;
import menu.commands.person.CRUD.ReadPersonCommand;
import menu.commands.person.CRUD.UpdatePersonCommand;
import menu.options.person.PersonOption;
import utls.MenuUtils;

public class PersonCommand implements Command {
    private static PersonCommand instance;

    private PersonCommand() {
    }

    public static synchronized PersonCommand getInstance() {
        if (instance == null) {
            instance = new PersonCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printOptions(PersonOption.values());
        Enum choose = MenuUtils.selectedCommand(PersonOption.values());

        if (choose.equals(PersonOption.MAIN_MENU)) {
            return MainMenuCommand.getInstance();
        } else if (choose.equals(PersonOption.CREATE_PERSON)) {
            return CreatePersonCommand.getInstance();
        } else if (choose.equals(PersonOption.DELETE_PERSON)) {
            return DeletePersonCommand.getInstance();
        } else if (choose.equals(PersonOption.UPDATE_PERSON)) {
            return UpdatePersonCommand.getInstance();
        } else if (choose.equals(PersonOption.READ_PERSON)) {
            return ReadPersonCommand.getInstance();
        } else if (choose.equals(PersonOption.SAVE_PERSON)) {
            return PersonSaveCommand.getInstance();
        } else {
            return ExitCommand.getInstance();
        }
    }
}
