package commands.userCommand;

import commands.AbstractCommand;
import data.StudyGroup;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.JavaCollectionManager;

/**
 * Команда выводит в консоль все элементы коллекции
 */
public class Show extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public Show() {
        super("show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            if (collectionManager.getStudyGroupCollection().isEmpty()) {
                System.out.println("Коллекция пуста.");
            } else for (StudyGroup index : collectionManager.getStudyGroupCollection()) {
                System.out.println(index.toString());
            }
        } catch (CommandNotAcceptArgumentsException e) {
            e.printStackTrace();
        }
        finally {
            toHistory();
        }
    }
}
