package menu;


import menu.commands.ExitCommand;
import menu.commands.exercise.ExerciseCommand;
import menu.commands.person.PersonCommand;
import menu.options.mainmenu.MainMenuOption;
import utls.MenuUtils;

public class MainMenuCommand implements Command {

    private static MainMenuCommand instance;

    private MainMenuCommand() {
    }

    public static synchronized MainMenuCommand getInstance() {
        if (instance == null) {
            instance = new MainMenuCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printOptions(MainMenuOption.values());
        Enum choose = MenuUtils.selectedCommand(MainMenuOption.values());

        if (choose.equals(MainMenuOption.PERSON_REPOSITORY)) {
            return PersonCommand.getInstance();
        } else if (choose.equals(MainMenuOption.EXERCISE)) {
            return ExerciseCommand.getInstance();
        } else {
            return ExitCommand.getInstance();
        }
    }
}
