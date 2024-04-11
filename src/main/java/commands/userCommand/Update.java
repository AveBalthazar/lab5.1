package commands.userCommand;

import commands.AbstractCommand;
import data.StudyGroup;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.CreateNewElementManager;
import utility.JavaCollectionManager;

/**
 * Команда обновляет значение элемента коллекции
 */
public class Update extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();

    public Update() {
        super("update - обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new CommandNeedArgumentException("Команда требует наличия аргумента. Введите update и id элемента, " +
                    "значение которого хотите обновить");
            try {
                int id = Integer.parseInt(argument);
                for (StudyGroup studyGroup : collectionManager.getStudyGroupCollection()) {
                    if (studyGroup.getId() == id) {
                        CreateNewElementManager.update(studyGroup);
                    } else {
                        throw new IllegalArgumentException("Элемента с таким id не найдено");
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (CommandNotAcceptArgumentsException e) {
            e.printStackTrace();
        } finally {
            toHistory();
        }
    }
}
