package menu.commands.exercise;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.exercise.max.MaxExerciseCommand;
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
            MenuUtils.printDivider();
            MenuUtils.printOption(0, "Main Menu");
            MenuUtils.printOption(1, "Max Filter Service");
            MenuUtils.printDivider();
            MenuUtils.printPrompt();

            int choice = MenuUtils.getUserChooseAsNumber();

            switch (choice) {
                case 0:
                    return MainMenuCommand.getInstance();
                case 1:
                    return MaxExerciseCommand.getInstance();
                default:
                    System.out.println("Unexpected command!");
                    return this;
            }
        }
}
