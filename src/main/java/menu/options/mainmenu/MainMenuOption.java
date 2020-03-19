package menu.options.mainmenu;

public enum MainMenuOption {
    EXIT("Exit"),
    EXERCISE("Exercise"),
    PERSON_REPOSITORY("Person repository");

    private String value;

    MainMenuOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
