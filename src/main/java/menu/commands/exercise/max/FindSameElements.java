package menu.commands.exercise.max;

import models.Person;

import java.util.List;

@FunctionalInterface

public interface FindSameElements {
    void findSameElements(List<Person> persons, GetKey getKey);
}
