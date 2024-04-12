package commands.userCommand;

import commands.AbstractCommand;
import exception.CommandNotAcceptArgumentsException;
import utility.HistoryBuffer;

/**
 * Команда, показывающая 11 последних команд
 */
public class History extends AbstractCommand {
    public History() {
        super("history - вывести последние 11 команд (без их аргументов)");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            for (String value : HistoryBuffer.getAll()) {
                System.out.println(value);
            }
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } finally {
            toHistory();
        }
    }
}
