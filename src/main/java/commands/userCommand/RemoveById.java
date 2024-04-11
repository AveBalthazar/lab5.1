package commands.userCommand;

import commands.AbstractCommand;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.JavaCollectionManager;

/**
 * Команда удаляет элемент из коллекции по id
 */
public class RemoveById extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public RemoveById() {
        super("remove_by_id - удалить элемент из коллекции по его id");
    }
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new CommandNeedArgumentException();
            try {
                int id = Integer.parseInt(argument);
                collectionManager.getStudyGroupCollection().removeIf(route -> (route.getId() == id));
                System.out.println("Удалён элемент по id: " + id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (CommandNotAcceptArgumentsException e) {
            e.printStackTrace();
        } finally {
            toHistory();
        }
    }
    @Override
    public String getName() {
        return "remove_by_id";
    }
}
