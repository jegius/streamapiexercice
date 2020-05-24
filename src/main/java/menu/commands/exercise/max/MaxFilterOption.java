package menu.commands.exercise.max;

public enum MaxFilterOption {
    BACK("Back"),
    CHOOSE_WOMEN("Choose women"),
    CHOOSE_PERSON_BY_AGE("Choose persons > 23 y.o. and < 30 y.o."),
    CHOOSE_MEN_AND_WOMEN_BY_AGE("Choose women < 25 y.o. and men > 30 y.o."),
    FIND_SAME_PHONE_NUMBERS("Find the same phone numbers"),
    GET_ARRAY_SAME_NAMES("Choose persons with the same names"),
    GET_ARRAY_SAME_AGES("Choose persons of the same ages"),
    GET_ARRAY_ONLY_NAMES("Choose persons with only names"),
    GET_ARRAY_ONLY_NAMES_AND_SURNAMES("Choose persons with only names and surnames"),
    GET_ARRAY_EMAILS("Choose emails with '_'"),
    COUNT_MEN_AND_WOMEN_BY_PERCENT("Count men and women by %"),
    COUNT_MEN_BY_PERCENT("Count men < 25 y.o. by %");

    private String value;

    public String getValue() {
        return value;
    }

    MaxFilterOption(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
