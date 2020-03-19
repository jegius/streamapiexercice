package menu.commands.exercise;

import menu.Command;
import menu.MainMenuCommand;

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
            return MainMenuCommand.getInstance();
        }
}
