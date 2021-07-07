package menu.commands.exercise.alexstreamapi;

import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import models.Gender;
import models.Person;
import repositories.PersonRepository;

import java.util.*;
import java.util.stream.Collectors;

public class AlexFilterService {
    private static final String phoneCode = "(\\(\\d{3}\\)) (.+)";

    private static final int FIRST_MAN_AGE = 23;
    private static final int SECOND_MAN_AGE = 30;
    private static final int THIRD_MAN_AGE = 30;
    private static final int WOMAN_AGE = 25;
    private static final int ONE_ELEMENT = 1;
    private static final String SEARCH_EMAIL_ELEMENT = "_";
    private static List<Person> people = PersonRepository
            .getInstance()
            .get();

    AlexFilterService() {
    }

    public static void femaleFilter() {
        people.stream()
                .filter(person -> person
                        .getGender()
                        .equals(Gender.FEMALE))
                .forEach(PersonCommandsUtils::printWebsites);
    }

    public static void filterByAge() {
        people.stream()
                .filter(person -> person.getAge() > FIRST_MAN_AGE && person.getAge() < SECOND_MAN_AGE)
                .forEach(PersonCommandsUtils::printWebsites);
    }

    public static void menAndWomenAgeFilter() {
        PersonFilter personFilter = person -> person
                .getGender()
                .equals(Gender.MALE) && person
                .getAge() > THIRD_MAN_AGE ||
                person
                        .getGender()
                        .equals(Gender.FEMALE) && person
                        .getAge() < WOMAN_AGE;

        people.stream()
                .filter(personFilter::filter)
                .forEach(PersonCommandsUtils::printWebsites);
    }

    static PrintFromMap<Person, String> printFromMap = map -> map.entrySet()
            .stream()
            .filter(array -> array.getValue().size() > ONE_ELEMENT)
            .forEach(array -> array.getValue()
                    .forEach(PersonCommandsUtils::printWebsites));


    public static void filterBySameNames() {
        SameElementKey sameElementKey = Person::getFirstName;
        printFromMap
                .print(sameElementMap
                        .completeMap(people, sameElementKey));
    }

    public static void filterBySameAge() {
        SameElementKey sameElementKey = person -> person
                .getAge()
                .toString();
        printFromMap
                .print(sameElementMap
                        .completeMap(people, sameElementKey));
    }

    public static List<String> getNames() {
        return people
                .stream()
                .map(Person::getFirstName)
                .collect(Collectors.toList());
    }

    public static List<String> getNameAndLastName() {
        return people
                .stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());
    }

    public static void printElementsFromArray(List<String> providedArray) {
        providedArray.forEach(System.out::println);
    }

    public static void findEmails() {
        people.stream()
                .filter(person -> person.getEmail()
                .contains(SEARCH_EMAIL_ELEMENT))
                .forEach(person -> System.out.println(person.getEmail()));
    }

    public static void genderPercent() {
        long manAmount = people
                .stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .count();
        long peopleAmount = people
                .size();
        System.out.println((manAmount * 100) / peopleAmount + "% - men");
        System.out.println(100 - (manAmount * 100) / peopleAmount + "% - women");
    }

    public static void menOfAgePercent(int age) {
        long manAmount = people
                .stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .count();
        long manUnder25 = people
                .stream()
                .filter(person -> person.getGender().equals(Gender.MALE) && person.getAge() < age)
                .count();
        System.out.println((manUnder25 * 100) / manAmount + "%");
    }

    static SameElementMap sameElementMap = (people, sameElementMap) -> {
        HashMap<String, List<Person>> peopleMap = new HashMap<>();
        people.forEach(person -> {
                    String key = sameElementMap.findKey(person);
                    if (peopleMap.containsKey(key)) {
                        peopleMap.get(key).add(person);
                    } else {
                        peopleMap.put(key, new ArrayList<>(Collections.singletonList(person)));
                    }
                }
        );
        return peopleMap;
    };

    public static void filterBySameNumber() {
        SameElementKey sameElementFilter = person ->
                person
                        .getPhone()
                        .replaceAll(phoneCode, "$1");
        printFromMap
                .print(sameElementMap
                        .completeMap(people, sameElementFilter));
    }
}
