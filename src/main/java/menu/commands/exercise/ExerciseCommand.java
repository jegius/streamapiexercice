package menu.commands.exercise;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.exercise.alexstreamapi.AlexStreamApiCommand;
import menu.options.ExerciseOption;
import utls.MenuUtils;

public class ExerciseCommand implements Command {
    private static ExerciseCommand instance;

    private ExerciseCommand() {
    }

    public static synchronized ExerciseCommand getInstance() {
        if (instance == null) {
            instance = new ExerciseCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printOptions(ExerciseOption.values());
        Enum choice = MenuUtils.selectedCommand(ExerciseOption.values());
        if (choice == ExerciseOption.BACK) {
            return MainMenuCommand.getInstance();
        } else if (choice == ExerciseOption.ALEX) {
            return AlexStreamApiCommand.getInstance();
        } else {
            System.out.println("unexpected command");
            return this;
        }
    }
}
