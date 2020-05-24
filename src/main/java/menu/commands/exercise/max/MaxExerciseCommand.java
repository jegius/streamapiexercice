package menu.commands.exercise.max;

import menu.Command;
import menu.commands.ExitCommand;
import menu.commands.exercise.ExerciseCommand;
import utls.MenuUtils;

public class MaxExerciseCommand implements Command {

    private static MaxExerciseCommand instance;

    private MaxExerciseCommand(){
    }

    public static synchronized MaxExerciseCommand getInstance() {
        if (instance == null) {
            instance = new MaxExerciseCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printDivider();
        MenuUtils.printOptions(MaxFilterOption.values());

        Enum choose = MenuUtils.selectedCommand(MaxFilterOption.values());

        if (choose.equals(MaxFilterOption.BACK)) {
            return ExerciseCommand.getInstance();
        } else if (choose.equals(MaxFilterOption.CHOOSE_WOMEN)) {
            MaxFilter.chooseWomen();
            return this;
        } else if (choose.equals(MaxFilterOption.CHOOSE_PERSON_BY_AGE)) {
            MaxFilter.choosePersonByAge();
            return this;
        } else if (choose.equals(MaxFilterOption.CHOOSE_MEN_AND_WOMEN_BY_AGE)) {
            MaxFilter.chooseMenAndWomenByAge();
            return this;
        } else if (choose.equals(MaxFilterOption.FIND_SAME_PHONE_NUMBERS)) {
            MaxFilter.findSamePhoneNumbers();
            return this;
        } else if (choose.equals(MaxFilterOption.GET_ARRAY_SAME_NAMES)) {
            MaxFilter.chooseSameNames();
            return this;
        } else if (choose.equals(MaxFilterOption.GET_ARRAY_SAME_AGES)) {
            MaxFilter.chooseSameAges();
            return this;
        } else if (choose.equals(MaxFilterOption.GET_ARRAY_ONLY_NAMES)) {
            MaxFilter.chooseOnlyNames();
            return this;
        } else if (choose.equals(MaxFilterOption.GET_ARRAY_ONLY_NAMES_AND_SURNAMES)) {
            MaxFilter.chooseOnlyNamesAndSurnames();
            return this;
        } else if (choose.equals(MaxFilterOption.GET_ARRAY_EMAILS)) {
            MaxFilter.chooseEmails();
            return this;
        } else if (choose.equals(MaxFilterOption.COUNT_MEN_AND_WOMEN_BY_PERCENT)) {
            MaxFilter.countRatioMenAndWomen();
            return this;
        } else if (choose.equals(MaxFilterOption.COUNT_MEN_BY_PERCENT)) {
            MaxFilter.countYoungMen();
            return this;
        } else {
            return ExitCommand.getInstance();
        }
    }
}
