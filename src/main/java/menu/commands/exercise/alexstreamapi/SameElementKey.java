package menu.commands.exercise.alexstreamapi;

import models.Person;

@FunctionalInterface
public interface SameElementKey {
    String findKey(Person person);
}
