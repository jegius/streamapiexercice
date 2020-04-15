package menu.commands.exercise.alexstreamapi;

import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import models.Gender;
import models.Person;
import repositories.PersonRepository;

import java.util.*;
import java.util.stream.Collectors;

public class AlexFilterService {
    private static final String phoneCode = "(\\(\\d{3}\\)) (.+)";

    private static final int AGE_FILTER_LOW_VALUE = 23;
    private static final int AGE_FILTER_HIGH_VALUE = 30;
    private static final int MEN_AND_WOMEN_AGE_FILTER_MALE_VALUE = 30;
    private static final int MEN_AND_WOMEN_AGE_FILTER_FEMALE_VALUE = 25;
    private static final int AMOUNT_OF_SINGLE_VALUE = 1;
    private static final String SEARCH_EMAIL_ELEMENT = "_";
    private static final int MEN_AGE_PERCENT = 25;
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
                .filter(person -> person.getAge() > AGE_FILTER_LOW_VALUE && person.getAge() < AGE_FILTER_HIGH_VALUE)
                .forEach(PersonCommandsUtils::printWebsites);
    }

    public static void menAndWomenAgeFilter() {
        PersonFilter personFilter = person -> person
                .getGender()
                .equals(Gender.MALE) && person
                .getAge() > MEN_AND_WOMEN_AGE_FILTER_MALE_VALUE ||
                person
                        .getGender()
                        .equals(Gender.FEMALE) && person
                        .getAge() < MEN_AND_WOMEN_AGE_FILTER_FEMALE_VALUE;

        people.stream()
                .filter(personFilter::filter)
                .forEach(PersonCommandsUtils::printWebsites);
    }

    static PrintFromMap<Person, String> printFromMap = map -> map.entrySet()
            .stream()
            .filter(array -> array.getValue().size() > AMOUNT_OF_SINGLE_VALUE)
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
        return people.stream()
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
        people.stream().filter(person -> person.getEmail()
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

    public static void menUnder25Percent() {
        long manAmount = people
                .stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .count();
        long manUnder25 = people
                .stream()
                .filter(person -> person.getGender().equals(Gender.MALE) && person.getAge() < MEN_AGE_PERCENT)
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
