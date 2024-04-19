package utility;

import commands.AbstractCommand;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


/**
 * Класс управляет командами
 */
public class CommandManager {
    static CommandManager COMMAND_MANAGER = new CommandManager();
    public static CommandManager getInstance() {
        return COMMAND_MANAGER;
    }
    static HashMap<String, AbstractCommand> commands = new HashMap<>();
    Reflections reflections = new Reflections("commands.userCommand");
    public void setCommands() {
        try {
            Set<Class<? extends AbstractCommand>> classes = reflections.getSubTypesOf(AbstractCommand.class);
            for (Class<? extends AbstractCommand> clazz : classes) {
                AbstractCommand objCommand = clazz.newInstance();
                commands.put(UniversalUtility.CommandFormat(objCommand.getName()), objCommand);
            }
        } catch (IllegalAccessException | InstantiationException e) {
            System.out.println("Не получилось создать объект класса команды, прав доступа нет! Рефлексия не работает.");
        }
    }
    public HashMap<String, AbstractCommand> getCommands() {
        return commands;
    }
    /**
     * Метод запускает выполнение команды
     *
     * @param userCommand команда введенная пользователем
     * @param argument    аргумент команды введенной пользователем
     */
    public static void execute(String userCommand, String argument) throws IOException {
        try {
            commands.get(userCommand).execute(argument);
        } catch (NoSuchMethodError | NullPointerException e) {
            System.err.println("Команда не найдена!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
