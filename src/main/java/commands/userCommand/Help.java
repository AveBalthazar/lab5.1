package commands.userCommand;

import commands.AbstractCommand;
import commands.Command;
import exception.CommandNotAcceptArgumentsException;
import org.reflections.Reflections;
import utility.CommandManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Команда, выводящая справку по всем доступным командам
 */
public class Help extends AbstractCommand {
    public Help() {
        super("help - вывести справку по доступным командам");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            HashMap<String, AbstractCommand> commands = CommandManager.getInstance().getCommands();
            commands.values().forEach(command -> System.out.println(command.getDescription()));
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } finally {
            toHistory();
        }
    }
}
