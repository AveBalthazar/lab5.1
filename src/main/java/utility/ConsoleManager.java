package utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Класс управляет пользовательским вводом.
 */
public class ConsoleManager {
    /**
     * Пользовательский ввод с консоли (по умолчанию).
     */
    private static Scanner userScanner = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     * Считывает из пользовательского ввода введенную команду.
     */
    public static void interactiveMode() throws IOException {
        if (userScanner.hasNext()) {
            String[] userCommand = (userScanner.nextLine().toLowerCase().trim() + " ").split(" ", 2);
            if (!((userCommand[0] + userCommand[1]).isEmpty())) {
                if (userCommand[1].isEmpty()) {
                    System.out.println("Выполнение " + userCommand[0] + " ...");
                } else {
                    System.out.println("Выполнение " + userCommand[0] + " с заданным аргументом...");
                }
                CommandManager.execute(userCommand[0], userCommand[1].trim());
            }
            System.out.print("-> ");
        }
    }

    /**
     * Возвращает пользовательский ввод, очищенный от мусора.
     *
     * @return String - из пользовательского ввода
     */
    public static String getUserPrint() {
        String userPrint;
        if (!userScanner.hasNext()) {
            setUserScanner(new Scanner(System.in));
            userPrint = userScanner.nextLine().trim().toLowerCase();
        } else {
            userPrint = userScanner.nextLine().trim().toLowerCase();
        }
        return userPrint;
    }

    /**
     * Изменить канал получения пользовательского ввода
     *
     * @param userScanner Scanner с пользовательским вводом
     */
    public static void setUserScanner(Scanner userScanner) {
        ConsoleManager.userScanner = userScanner;
    }

}
