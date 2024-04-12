package commands.userCommand;

import commands.AbstractCommand;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.JavaCollectionManager;

/**
 * Команда, выполняющая очистку текущей коллекции
 */
public class Clear extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public Clear() {
        super("clear - очистить коллекцию");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            collectionManager.clear();
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } finally {
            toHistory();
        }
    }
}
