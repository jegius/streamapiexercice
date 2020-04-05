package menu.commands.exercise.alexstreamapi;

import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import models.Gender;
import models.Person;
import repositories.PersonRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AlexFilterService {
    private static final String phoneCode = "(\\(\\d{3}\\)) (.+)";

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
                .filter(person -> person.getAge() > 23 && person.getAge() < 30)
                .forEach(PersonCommandsUtils::printWebsites);
    }

    public static void menAndWomenAgeFilter() {
        PersonFilter personFilter = person -> person
                .getGender()
                .equals(Gender.MALE) && person
                .getAge() > 30 || person
                .getGender()
                .equals(Gender.FEMALE) && person
                .getAge() < 25;

        people.stream()
                .filter(personFilter::filter)
                .forEach(PersonCommandsUtils::printWebsites);
    }

    public static void filterBySameNames() {
        HashMap<String, List<Person>> peopleNameMap = new HashMap<>();

        people.forEach(person -> {
            if (peopleNameMap.containsKey(person.getFirstName())) {
                peopleNameMap.get(person.getFirstName()).add(person);
            } else {
                List<Person> arrayPerson = new ArrayList<>();
                arrayPerson.add(person);
                peopleNameMap.put(person.getFirstName(), arrayPerson);
            }
        });

        peopleNameMap
                .entrySet()
                .stream()
                .filter(element -> element.getValue().size() > 1)
                .forEach(b -> b.getValue()
                        .forEach(PersonCommandsUtils::printWebsites));
    }

    public static void filterBySameAge() {
        HashMap<Long, List<Person>> peopleAgeMap = new HashMap<>();
        people.forEach(person -> {
            if (peopleAgeMap.containsKey(person.getAge())) {
                peopleAgeMap.get(person.getAge()).add(person);
            } else {
                List<Person> arrayPerson = new ArrayList<>();
                arrayPerson.add(person);
                peopleAgeMap.put(person.getAge(), arrayPerson);
            }
        });

        peopleAgeMap
                .entrySet()
                .stream()
                .filter(arrayOfPeople -> arrayOfPeople.getValue().size() > 1)
                .forEach(arrayOfPeople -> arrayOfPeople.getValue()
                        .forEach(PersonCommandsUtils::printWebsites));
    }

    private static List<String> getNames() {
        return people.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toList());
    }

    public static void printNames() {
        getNames()
                .forEach(System.out::println);
    }

    private static List<String> getNameAndLastName() {
        return people.stream().map(p -> p.getFirstName() + " " + p.getLastName()).collect(Collectors.toList());
    }

    public static void printNamesAndLastNames() {
        getNameAndLastName().forEach(System.out::println);
    }

    public static void findEmails() {
        people.stream().filter(person -> person.getEmail()
                .contains("_"))
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
                .filter(person -> person.getGender().equals(Gender.MALE) && person.getAge() < 25)
                .count();
        System.out.println((manUnder25 * 100) / manAmount + "%");
    }

    public static void filterBySameNumber() {
        HashMap<String, List<Person>> numberMap = new HashMap<>();
        people.forEach(person -> {
            String phoneNumber = person.getPhone().replaceAll(phoneCode, "$1");
            if (numberMap.containsKey(phoneNumber)) {
                numberMap.get(phoneNumber).add(person);
            } else {
                List<Person> peopleArray = new ArrayList<>();
                peopleArray.add(person);
                numberMap.put(phoneNumber, peopleArray);
            }
        });

        numberMap
                .entrySet()
                .stream()
                .filter(peopleArray -> peopleArray.getValue().size() > 1)
                .forEach(peopleArray -> peopleArray.getValue()
                        .forEach(PersonCommandsUtils::printWebsites));
    }


}
