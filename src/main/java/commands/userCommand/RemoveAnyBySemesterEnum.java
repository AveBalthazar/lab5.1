package commands.userCommand;

import commands.AbstractCommand;
import data.Semester;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.JavaCollectionManager;
import utility.UniversalUtility;

/**
 * Команда удаляет из коллекции один элемент, значение поля semesterEnum которого эквивалентно заданному
 */
public class RemoveAnyBySemesterEnum extends AbstractCommand {
    private final CollectionManager collectionManager = JavaCollectionManager.getInstance();
    public RemoveAnyBySemesterEnum() {
        super("remove_any_by_semester_enum - удалить из коллекции один элемент, значение поля semesterEnum которого эквивалентно заданному");
    }
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new CommandNeedArgumentException();
            try {
                Semester semester = Semester.valueOf(argument.toUpperCase());
                collectionManager.getStudyGroupCollection().removeIf(studyGroup -> (studyGroup.getSemester() == semester));
                System.out.println("Удалён элемент с Semester: " + semester.toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (CommandNotAcceptArgumentsException e) {
            e.printStackTrace();
        } finally {
            toHistory();
        }
    }
    @Override
    public String getName() {
        return "remove_any_by_semester_enum";
    }
}
