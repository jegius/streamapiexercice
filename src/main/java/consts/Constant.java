package consts;

public enum Constant {
    BASE_PATH("src/main/resources/store"),
    PERSON_PATH("person.json");

    private String value;

    Constant(String value) {
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
