package utility;

import commands.Command;

import java.io.IOException;


/**
 * Класс управляет командами
 */
public class CommandManager {

    /**
     * Метод запускает выполнение команды
     *
     * @param userCommand команда введенная пользователем
     * @param argument    аргумент команды введенной пользователем
     */

    public static void execute(String userCommand, String argument) throws IOException {
        try {
            String commandName = "commands.userCommand." + UniversalUtility.CommandFormat(userCommand);
            Command obj = (Command) Class.forName(commandName).newInstance();
            obj.execute(argument);
        } catch (ClassNotFoundException | NoSuchMethodError e) {
            System.err.println("Команда не найдена!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
