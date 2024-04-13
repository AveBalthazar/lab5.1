package data;

import exception.CollectionException;
import utility.CollectionManager;
import utility.JavaCollectionManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Элементы коллекцией, которыми управляет программа
 */
public class StudyGroup {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private Integer transferredStudents; //Значение поля должно быть больше 0, Поле может быть null
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле не может быть null
    /**
     * Все поля StudyGroup в виде String
     */
    private List<String> studyGroupList = new ArrayList<>();
    private CollectionManager collectionManager = JavaCollectionManager.getInstance();

    /**
     * @param id                    StudyGroup id
     * @param name                  StudyGroup name
     * @param coordinates           StudyGroup coordinates
     * @param creationDate          StudyGroup creationDate
     * @param studentsCount         StudyGroup studentsCount
     * @param transferredStudents   StudyGroup transferredStudents
     * @param formOfEducation       StudyGroup formOfEducation
     * @param semesterEnum          StudyGroup semesterEnum
     * @param groupAdmin            StudyGroup groupAdmin
     */
    public StudyGroup(String id, String name, Coordinates coordinates, String creationDate,
                      Long studentsCount, Integer transferredStudents, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        try {
            if (id.isEmpty()) this.id = collectionManager.getFreeNumberForId();
            else this.id = Integer.parseInt(id);
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("name is null! check csv file!");
            }
            else this.name = name;
            if (coordinates == null) {
                System.out.println("coordinates is null! check csv file!");
                throw new CollectionException();
            }
            else this.coordinates = coordinates;
            if (creationDate.isEmpty()) this.creationDate = collectionManager.getLastInitTime();
            else this.creationDate = LocalDateTime.parse(creationDate);
            if (formOfEducation == null) {
                System.out.println("formOfEducation is null! check csv file!");
                throw new CollectionException();
            }
            else this.formOfEducation = formOfEducation;
            if (semesterEnum == null) {
                System.out.println("semesterEnum is null! check csv file!");
                throw new CollectionException();
            }
            else this.semesterEnum = semesterEnum;
            if (transferredStudents <= 0) {
                System.out.println("transferredStudents incorrect! check csv file!");
                throw new CollectionException();
            }
            else this.transferredStudents = transferredStudents;
            if (studentsCount <= 0 || studentsCount == null) {
                System.out.println("studentsCount incorrect! check csv file!");
                throw new CollectionException();
            }
            else this.studentsCount = studentsCount;
            if (groupAdmin == null) {
                System.out.println("groupAdmin is null! check csv file!");
                throw new CollectionException();
            }
            else this.groupAdmin = groupAdmin;

            studyGroupList.add(((Integer) this.id).toString());
            studyGroupList.add(name);
            studyGroupList.add(((Long) coordinates.getX()).toString());
            studyGroupList.add(coordinates.getY().toString());
            studyGroupList.add(this.creationDate.toString());
            studyGroupList.add(this.studentsCount.toString());
            studyGroupList.add(transferredStudents.toString());
            studyGroupList.add(formOfEducation.toString());
            studyGroupList.add(semesterEnum.toString());
            studyGroupList.add(groupAdmin.toString());
            String[] str = {studyGroupList.get(0), studyGroupList.get(1), studyGroupList.get(2), studyGroupList.get(3), studyGroupList.get(4),
                    studyGroupList.get(5), studyGroupList.get(6), studyGroupList.get(7), studyGroupList.get(8), studyGroupList.get(9)};
            collectionManager.addStringStudyGroupCollection(str);
        } catch (IllegalArgumentException | CollectionException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Обновить поля элемента StudyGroup
     *
     * @param studyGroup новый элемент StudyGroup
     */
    public void updateStudyGroup(StudyGroup studyGroup) {
        this.id = studyGroup.id;
        this.name = studyGroup.name;
        this.coordinates = studyGroup.coordinates;
        this.studentsCount = studyGroup.studentsCount;
        this.transferredStudents = studyGroup.transferredStudents;
        this.formOfEducation = studyGroup.formOfEducation;
        this.semesterEnum = studyGroup.semesterEnum;
        this.groupAdmin = studyGroup.groupAdmin;
    }
    public Semester getSemester() {
        return this.semesterEnum;
    }
    public FormOfEducation getFormOfEducation() {
        return this.formOfEducation;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", " + coordinates.toString() +
                ", creationDate: " + creationDate + ", studentsCount: " + studentsCount +
                ", transferredStudents: " + transferredStudents + ", formOfEducation: " +
                formOfEducation + ", semesterEnum: " + semesterEnum + ", groupAdmin: " + groupAdmin;
    }
    public int compareTo(StudyGroup studyGroupObj) {
        Integer compareId = id;
        return compareId.compareTo(studyGroupObj.getId());
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
}
