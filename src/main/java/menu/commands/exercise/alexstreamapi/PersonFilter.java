package menu.commands.exercise.alexstreamapi;

import models.Person;

@FunctionalInterface
public interface PersonFilter {
    boolean filter(Person person);
}
