package menu.commands.exercise.max;

import models.Person;

@FunctionalInterface

public interface GetKey {
    String getKey(Person person);
}
