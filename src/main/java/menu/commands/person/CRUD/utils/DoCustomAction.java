package menu.commands.person.CRUD.utils;


import models.Person;

@FunctionalInterface
public interface DoCustomAction {
    void doAction(Person person);
}
