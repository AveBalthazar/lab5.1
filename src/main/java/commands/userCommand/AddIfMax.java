package commands.userCommand;

import commands.AbstractCommand;
import data.StudyGroup;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.CreateNewElementManager;
import utility.JavaCollectionManager;

/**
 * Команда, позволяющая добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
 */
public class AddIfMax extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public AddIfMax() {
        super("add_if_max - добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            StudyGroup studyGroup = CreateNewElementManager.createNewElement();
            boolean flag = false;
            for (StudyGroup index : collectionManager.getStudyGroupCollection()) {
                if (studyGroup.compareTo(index) > 0) {
                    flag = true;
                }
            }
            if (flag) {
                collectionManager.getStudyGroupCollection().add(studyGroup);
                System.out.println("Элемент добавлен");
            } else {
                System.out.println("Элемент НЕ добавлен");
            }
        } catch (CommandNotAcceptArgumentsException e) {
            e.printStackTrace();
        } finally {
            toHistory();
        }
    }
    @Override
    public String getName() {
        return "add_if_max";
    }
}
