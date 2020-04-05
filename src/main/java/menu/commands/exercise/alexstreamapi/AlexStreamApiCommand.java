package menu.commands.exercise.alexstreamapi;

import menu.Command;
import menu.commands.ExitCommand;
import menu.commands.exercise.ExerciseCommand;
import menu.options.alex.AlexStreamApiExerciseOption;
import utls.MenuUtils;

public class AlexStreamApiCommand implements Command {

    private static AlexStreamApiCommand instance;

    public static synchronized AlexStreamApiCommand getInstance() {
        if (instance == null) {
            instance = new AlexStreamApiCommand();
        }
        return instance;
    }


    @Override
    public Command execute() {
        MenuUtils.printOptions(AlexStreamApiExerciseOption.values());


        Enum choice = MenuUtils.selectedCommand(AlexStreamApiExerciseOption.values());
        if (choice == AlexStreamApiExerciseOption.BACk) {
            return ExerciseCommand.getInstance();
        } else if (choice == AlexStreamApiExerciseOption.FEMALE_FILTER) {
            AlexFilterService.femaleFilter();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.BETWEEN_23_30) {
            AlexFilterService.filterByAge();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.WOMEN_UNDER_25_AND_MAN_ABOVE_30) {
            AlexFilterService.menAndWomenAgeFilter();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.MATCH_NAMES_ARRAY) {
            AlexFilterService.filterBySameNames();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.ONLY_NAMES) {
            AlexFilterService.printNames();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.ONLY_NAMES_LAST_NAMES) {
            AlexFilterService.printNamesAndLastNames();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.MATCH_AGES_ARRAY) {
            AlexFilterService.filterBySameAge();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.ONLY_EMAILS) {
            AlexFilterService.findEmails();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.PERCENTS_OF_MEN_WOMEN) {
            AlexFilterService.genderPercent();
            return this;
        } else if (choice == AlexStreamApiExerciseOption.PERCENT_OF_MEN_UNDER_25) {
            AlexFilterService.menUnder25Percent();
            return this;
        } else if(choice == AlexStreamApiExerciseOption.PHONE_NUMBER_MATCH) {
            AlexFilterService.filterBySameNumber();
            return this;
        }
        return ExitCommand.getInstance();
    }
}
