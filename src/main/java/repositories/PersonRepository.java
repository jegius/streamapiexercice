package repositories;

import consts.Constant;
import models.Person;
import utls.JSONUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository<Person> {
    private static final long START_ID = 0;

    private static PersonRepository instance;

    private List<Person> people;

    private PersonRepository() {
    }

    public static synchronized PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
            instance.load();
        }
        return instance;
    }

    @Override
    public List<Person> get() {
        return people;
    }

    public Person getById(Long id) {
        return people
                .stream()
                .filter(webSite -> webSite.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public Person add(Person object) {
        if (object == null) {
            return null;
        }

        Person person = new Person(object);
        person.setId(generateId());
        people.add(person);

        return person;
    }

    @Override
    public Person update(Person object) {
        if (object == null) {
            return null;
        }

        Person person = new Person(object);
        remove(person);
        people.add(person);

        return person;
    }

    @Override
    public void remove(Person object) {
        if (object == null) {
            return;
        }

        people.remove(getById(object.getId()));
    }

    @Override
    public void save() {
        try {
            JSONUtils.writeToFile(Constant.PERSON_PATH.toString(), people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            people = JSONUtils.readListFromFile(Constant.PERSON_PATH.toString(), Person.class);
        } catch (IOException e) {
            people = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private long generateId() {
        return people
                .stream()
                .map(Person::getId)
                .mapToLong(itemId -> ++itemId)
                .max()
                .orElse(START_ID);
    }
}
