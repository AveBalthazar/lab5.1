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
        super("update id - обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new CommandNeedArgumentException("Команда требует наличия аргумента. Введите update и id элемента, " +
                    "значение которого хотите обновить");
            try {
                Boolean flag = Boolean.FALSE;
                int id = Integer.parseInt(argument);
                for (StudyGroup studyGroup : collectionManager.getStudyGroupCollection()) {
                    if (studyGroup.getId() == id) {
                        flag = Boolean.TRUE;
                        CreateNewElementManager.update(studyGroup);
                    }
                }
                if (Boolean.FALSE.equals(flag)) {
                    throw new IllegalArgumentException("Элемента с таким id не найдено");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
            }
        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println(e.toString());
        } finally {
            toHistory();
        }
    }
}
