package utility;

import java.io.IOException;

public class Session {

    public void startUp() throws IOException {
        CommandManager commandManager = CommandManager.getInstance();
        FileManager fileManager = FileManager.getInstance();
        commandManager.setCommands();
        fileManager.setEnv("lab");
        CollectionManager collectionManager = JavaCollectionManager.getInstance();
        collectionManager.loadCollection(fileManager);
        System.out.println("Введите help для получения списка доступных команд");
        while (true) {
            ConsoleManager.interactiveMode();
        }
    }
}