package menu.options.person;

public enum PersonOption {
    MAIN_MENU("Main menu"),
    UPDATE_PERSON("Update person"),
    READ_PERSON("View person"),
    DELETE_PERSON("Delete person"),
    CREATE_PERSON("Create person"),
    SAVE_PERSON("Save all person");

    private String value;

    PersonOption(String value) {
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
