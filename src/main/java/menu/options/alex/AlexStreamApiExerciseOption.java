package menu.options.alex;

public enum AlexStreamApiExerciseOption {
    BACk("back"),
    FEMALE_FILTER("female only"),
    BETWEEN_23_30("between 23 - 30"),
    WOMEN_UNDER_25_AND_MAN_ABOVE_30("women under 25 and men above 30"),
    PHONE_NUMBER_MATCH("phone number match"),
    MATCH_NAMES_ARRAY("match names array"),
    MATCH_AGES_ARRAY("match ages array"),
    ONLY_NAMES("only names"),
    ONLY_NAMES_LAST_NAMES("name and last name"),
    ONLY_EMAILS("only emails"),
    PERCENTS_OF_MEN_WOMEN("percent of men and women"),
    PERCENT_OF_MEN_UNDER_25("percent of men under 25");

    private String option;

    AlexStreamApiExerciseOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    @Override
    public String toString() {
        return option;
    }
}
