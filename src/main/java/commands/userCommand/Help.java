package commands.userCommand;

import commands.AbstractCommand;
import commands.Command;
import exception.CommandNotAcceptArgumentsException;
import org.reflections.Reflections;

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
            Reflections reflections = new Reflections("commands.userCommand");
            Set<Class<? extends AbstractCommand>> implementationClasses = reflections.getSubTypesOf(AbstractCommand.class);
            for (Class<? extends AbstractCommand> clazz : implementationClasses) {
                Command command = clazz.newInstance();
                System.out.println(command.getDescription());
            }
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } finally {
            toHistory();
        }
    }
}
