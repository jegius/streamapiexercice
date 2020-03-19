package menu.commands.person.CRUD;


import menu.Command;
import menu.commands.person.CRUD.utils.DoCustomAction;
import menu.commands.person.CRUD.utils.PersonCommandsUtils;
import repositories.PersonRepository;
import utls.MenuUtils;

public class DeletePersonCommand implements Command {

    private static DeletePersonCommand instance;

    private DeletePersonCommand() {}

    public static synchronized DeletePersonCommand getInstance() {
        if (instance == null) {
            instance = new DeletePersonCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {

        DoCustomAction doCustomAction = webSite -> {
            PersonRepository.getInstance().remove(webSite);

            MenuUtils.printDivider();
            System.out.println("Person " + webSite.getLastName() + " has been removed");
            MenuUtils.waitForEnter();
        };

        return PersonCommandsUtils
                .checkWebsiteExistingAndDoCustomAction(this, doCustomAction);
    }
}
