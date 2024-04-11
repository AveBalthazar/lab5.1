package commands.userCommand;


import commands.AbstractCommand;
import exception.CommandNotAcceptArgumentsException;
import utility.FileManager;

import java.io.IOException;

/**
 * Команда сохраняет коллекцию в файл
 */

public class Save extends AbstractCommand {
    private FileManager fileManager = FileManager.getInstance();
    public Save() {
        super("save - сохранить коллекцию в файл");
    }
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            fileManager.saveCollection();
        } catch (CommandNotAcceptArgumentsException | IOException e) {
            e.printStackTrace();
        } finally {
            toHistory();
        }
    }
}
