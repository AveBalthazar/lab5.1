package commands.userCommand;

import commands.AbstractCommand;
import data.StudyGroup;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.JavaCollectionManager;

import java.util.ArrayList;

public class FilterContainsName extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public FilterContainsName() {
        super("filter_contains_name name - вывести элементы, значение поля name которых содержит заданную подстроку");
    }

    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new CommandNeedArgumentException();
            try {
                ArrayList<StudyGroup> collection = collectionManager.getStudyGroupCollection();
                System.out.println("Элементы, значение поля name которых содержит " + argument + ":");
                for (StudyGroup studyGroup : collection) {
                    if (studyGroup.getName().contains(argument)) {
                        System.out.println(studyGroup.toString());
                    }
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
