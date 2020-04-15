package menu.commands.exercise.alexstreamapi;

import models.Person;

import java.util.HashMap;
import java.util.List;

@FunctionalInterface
public interface SameElementMap {
    HashMap <String, List<Person>> completeMap(List<Person> people, SameElementKey sameElementFilter);
}
