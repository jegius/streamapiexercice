package menu.commands.exercise.max;

import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import models.Gender;
import models.Person;
import repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MaxFilter {

    private static final String SAME_PHONE_NUMBER = "(\\(\\d{3}\\))(.+)";

    private static List<Person> people = PersonRepository
            .getInstance()
            .get();

    public static void chooseWomen() {
        people.stream()
                .filter(person -> person
                        .getGender()
                        .equals(Gender.FEMALE))
                .forEach(PersonCommandsUtils::printWebsites);
    }

    public static void choosePersonByAge() {
        people.stream()
                .filter(person -> person
                        .getAge() > 23 && person
                        .getAge() < 30)
                .forEach(PersonCommandsUtils::printWebsites);
    }

    public static void chooseMenAndWomenByAge() {
        people.stream()
                .filter(person -> (
                        person
                                .getGender()
                                .equals(Gender
                                        .FEMALE) && person
                                .getAge() < 25 ||
                        person
                                .getGender()
                                .equals(Gender
                                        .MALE) && person
                                .getAge() > 30))
                .forEach(PersonCommandsUtils::printWebsites);
    }

    static FindSameElements findSameElements = (persons, getKey) -> {
        HashMap<String, ArrayList<Person>> hashMapSameElements = new HashMap();

        persons.forEach(person -> {
            String key = getKey.getKey(person);

            if (hashMapSameElements.containsKey(key)) {
                hashMapSameElements.get(key).add(person);
            } else {
                hashMapSameElements.put(key, new ArrayList<>(Collections.singletonList(person)));
            }
        });

        hashMapSameElements
                .entrySet()
                .stream()
                .filter(stringArrayListEntry -> stringArrayListEntry
                        .getValue()
                        .size() > 1)
                .forEach(stringArrayListEntry -> stringArrayListEntry
                        .getValue()
                        .forEach(PersonCommandsUtils::printWebsites));
    };

    public static void findSamePhoneNumbers() {
        GetKey getKey = person -> person
                .getPhone()
                .replaceAll(SAME_PHONE_NUMBER, "$1");
        findSameElements.findSameElements(people, getKey);
    }

    public static void chooseSameNames() {
        GetKey getKey = Person::getFirstName;
        findSameElements.findSameElements(people, getKey);
    }

    public static void chooseSameAges() {
        GetKey getKey = person -> person
                .getAge().toString();
        findSameElements.findSameElements(people, getKey);
    }

    public static void chooseOnlyNames() {
        List<String> firstNames =
        people.stream()
                .map(Person::getFirstName)
                .collect(Collectors
                        .toList());
        firstNames.forEach(System.out::println);
    }

    public static void chooseOnlyNamesAndSurnames() {
        List<String> names =
        people.stream()
                .map(person ->
                        person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }

    public static void chooseEmails() {
        List<String> emails = new ArrayList<>();
        people.forEach(person -> {
            if (person.getEmail().contains("_")) {
                emails.add(person.getEmail());
            }
        });
        emails.forEach(System.out::println);
    }

    public static void countRatioMenAndWomen() {
        long numberWomen = people.stream()
                .filter(person ->
                        person
                                .getGender()
                                .equals(Gender.FEMALE))
                .count();

        long numberPeople = numberWomen + getCountMen();
        long ratioFemale = (long) (100.0 / numberPeople * numberWomen);
        long ratioMale = (long) (100.0 / numberPeople * getCountMen());

        System.out.println("Ratio men and women:");
        System.out.println(getCountMen() + " men = " + ratioMale + "%");
        System.out.println(numberWomen + " women = " + ratioFemale + "%");
    }

    public static void countYoungMen() {
        long numberYoungMen = people
                .stream()
                .filter(person -> (person
                        .getGender()
                        .equals(Gender.MALE)) &&
                person
                        .getAge() < 25)
                .count();

        long ratioMale = (long) (100.0 / getCountMen() * numberYoungMen);

        System.out.println(getCountMen() + " men = " + ratioMale + "%");
    }

    private static Long getCountMen() {
        return people.stream()
                .filter(person ->
                        person
                                .getGender()
                                .equals(Gender.MALE))
                .count();
    }
}
