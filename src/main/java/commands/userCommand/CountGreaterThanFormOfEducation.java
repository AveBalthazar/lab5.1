package commands.userCommand;

import commands.AbstractCommand;
import data.FormOfEducation;
import data.StudyGroup;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.JavaCollectionManager;

import java.util.ArrayList;

/**
 * Команда, показывающая сколько элементов коллекции имеют {@link FormOfEducation} больше заданного
 */
public class CountGreaterThanFormOfEducation extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public CountGreaterThanFormOfEducation() {
        super("count_greater_than_form_of_education - вывести количество элементов, значение поля formOfEducation которых больше заданного");
    }
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new CommandNeedArgumentException();
            int count = 0;
            try {
                FormOfEducation formOfEducation = FormOfEducation.valueOf(argument.toUpperCase());
                ArrayList<StudyGroup> collection = collectionManager.getStudyGroupCollection();
                for (StudyGroup studyGroup : collection) {
                    if (formOfEducation.ordinal() > studyGroup.getFormOfEducation().ordinal()) {
                        count++;
                    }
                }
                System.out.println("Количество элементов с FormOfEducation больше введённого (" + formOfEducation.toString() + "): " + count);
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
