package commands.userCommand;

import commands.AbstractCommand;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.JavaCollectionManager;

/**
 * Команда выводит основную информацию о коллекции
 */
public class Info extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public Info() {
        super("info - вывести в стандартный поток вывода информацию о коллекции тип, дата инициализации, количество элементов и т.д.");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            System.out.println("Сведения о коллекции:");
            System.out.println("Тип: " + collectionManager.getStudyGroupCollection().getClass().getName());
            System.out.println("Дата инициализации: " + collectionManager.getLastInitTime());
            String saveTime = "";
            if (collectionManager.getSaveTimeCollection() == null) {
                saveTime = "Коллекция не сохранялась в этой сессии";
            } else saveTime = collectionManager.getSaveTimeCollection().toString();
            System.out.println("Дата сохранения: " + saveTime);
            System.out.println("Количество элементов: " + collectionManager.getStudyGroupCollection().size());
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } finally {
            toHistory();
        }
    }
}
