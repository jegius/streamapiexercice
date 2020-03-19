package menu.commands.person.CRUD;


import menu.Command;
import menu.commands.person.CRUD.utils.DoCustomAction;
import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import repositories.PersonRepository;
import utls.MenuUtils;

import java.util.Scanner;

public class UpdatePersonCommand implements Command {

    private static UpdatePersonCommand instance;

    private UpdatePersonCommand() {}

    public static synchronized UpdatePersonCommand getInstance() {
        if (instance == null) {
            instance = new UpdatePersonCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        DoCustomAction doCustomAction = webSite -> {
            Scanner scanner = new Scanner(System.in);

            webSite.setLastName(PersonCommandsUtils.getLastName(scanner));
            webSite.setAge(PersonCommandsUtils.getAge(scanner));
            webSite.setFirstName(PersonCommandsUtils.getFirstName(scanner));
            webSite.setEmail(PersonCommandsUtils.getEmail(scanner));
            webSite.setPhone(PersonCommandsUtils.getPhone(scanner));
            webSite.setGender(PersonCommandsUtils.getGender(scanner));

            PersonRepository
                    .getInstance()
                    .update(webSite);

            MenuUtils.printDivider();
            System.out.println("Person has been updated");
        };

        return PersonCommandsUtils
                .checkWebsiteExistingAndDoCustomAction(this, doCustomAction);
    }
}
