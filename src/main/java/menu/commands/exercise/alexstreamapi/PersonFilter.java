package menu.commands.exercise.alexstreamapi;

import models.Person;

@FunctionalInterface
public interface PersonFilter {
    public boolean filter(Person person);
}
