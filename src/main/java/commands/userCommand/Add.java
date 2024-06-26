package commands.userCommand;

import commands.AbstractCommand;
import exception.CommandNotAcceptArgumentsException;
import utility.CreateNewElementManager;

/**
 * Команда добавить новый элемент в коллекцию
 */
public class Add extends AbstractCommand {
    public Add() {
        super("add - добавить новый элемент в коллекцию");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            try {
                CreateNewElementManager.add();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } finally {
            toHistory();
        }
    }
}
