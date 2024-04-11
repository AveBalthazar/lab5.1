package commands.userCommand;

import commands.AbstractCommand;
import exception.CommandNotAcceptArgumentsException;

/**
 * Команда для выхода из консольного приложения
 */
public class Exit extends AbstractCommand {
    public Exit() {
        super("exit - завершить программу (без сохранения в файл)");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            System.exit(0);
        } catch (CommandNotAcceptArgumentsException e) {
            e.printStackTrace();
        } finally {
            toHistory();
        }
    }
}
