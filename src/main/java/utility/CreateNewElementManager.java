package utility;

import commands.userCommand.Add;
import commands.userCommand.Update;
import data.*;

/**
 * Класс создаёт/обновляет элементы {@link StudyGroup} в интерактивном режиме.
 */
public class CreateNewElementManager {
    private static CollectionManager collectionManager = JavaCollectionManager.getInstance();

    /**
     * Обновить элемент {@link StudyGroup}
     *
     * @param oldstudyGroup элемент {@link StudyGroup} который мы хотим обновить.
     * @see Update
     */
    public static void update(StudyGroup oldstudyGroup) {
        StudyGroup studyGroup = new StudyGroup((Integer.valueOf(oldstudyGroup.getId()).toString()),
                askName(),
                new Coordinates(askCoordinateX(), askCoordinateY()),
                "",
                askStudentsCount(),
                askTransferredStudents(),
                askFormOfEducationName(),
                askSemester(),
                new Person(askPersonName(), askPersonWeight(), askPersonPassportID(), askPersonLocation()));
        updateCollection(1, studyGroup, oldstudyGroup);
    }

    /**
     * Создать новый элемент {@link StudyGroup}
     */
    public static StudyGroup createNewElement() {
        StudyGroup studyGroup = new StudyGroup("",
                askName(),
                new Coordinates(askCoordinateX(), askCoordinateY()),
                "",
                askStudentsCount(),
                askTransferredStudents(),
                askFormOfEducationName(),
                askSemester(),
                new Person(askPersonName(), askPersonWeight(), askPersonPassportID(), askPersonLocation()));
        System.out.println("Preview:");
        System.out.println(studyGroup.toString());
        return studyGroup;
    }

    /**
     * Добавить новый элемент {@link StudyGroup} в коллекцию
     *
     * @see Add
     */
    public static void add() {
        StudyGroup studyGroup = new StudyGroup("",
                askName(),
                new Coordinates(askCoordinateX(), askCoordinateY()),
                "",
                askStudentsCount(),
                askTransferredStudents(),
                askFormOfEducationName(),
                askSemester(),
                new Person(askPersonName(), askPersonWeight(), askPersonPassportID(), askPersonLocation()));
        updateCollection(0, studyGroup, null);
    }

    /**
     * Обновление коллекции
     *
     * @param mode     режим работы. 0 - добавление элемента в коллекцию, 1 - обновление элемента коллекции
     * @param newStudyGroup новый элемент {@link StudyGroup}
     * @param oldStudyGroup элемент {@link StudyGroup} который хотим обновить (если есть, иначе null)
     */
    private static void updateCollection(Integer mode, StudyGroup newStudyGroup, StudyGroup oldStudyGroup) {
        while (true) {
            try {
                if (mode == 0) {
                    System.out.println("Добавить элемент в коллекцию?");
                } else if (mode == 1) {
                    System.out.println("Обновить элемент в коллекции?");
                }
                System.out.println(newStudyGroup.toString());
                System.out.print("Введите y/n ");
                String userPrint = ConsoleManager.getUserPrint();
                if (userPrint.equals("y")) {
                    if (mode == 0) {
                        collectionManager.getStudyGroupCollection().add(newStudyGroup);
                        System.out.println("Элемент добавлен в коллекцию");
                    } else if (mode == 1) {
                        oldStudyGroup.updateStudyGroup(newStudyGroup);
                        System.out.println("Элемент обновлен");
                    }
                    break;
                } else if (userPrint.equals("n")) {
                    if (mode == 0) {
                        System.out.println("Добаление элемента в коллекцию ОТМЕНЕНО.");
                    } else if (mode == 1) {
                        System.out.println("Обновление элемента ОТМЕНЕНО.");
                    }
                    break;
                } else throw new IllegalArgumentException("Введено что-то не то. Повторите попытку.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * Спросить Имя {@link StudyGroup}
     *
     * @return StudyGroup name
     */
    private static String askName() {
        while (true) {
            System.out.print("Введите StudyGroup name (тип: String, не может быть пустой): ");
            try {
                String userPrint = ConsoleManager.getUserPrint();
                if (userPrint.equals("")) {
                    throw new IllegalArgumentException("Значение StudyGroup name не может быть пустой строкой.");
                }
                return userPrint;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    private static Long askCoordinateX() {
        while (true) {
            System.out.print("Введите Coordinate X (тип: long): ");
            try {
                return Long.parseLong(ConsoleManager.getUserPrint());
            } catch (NumberFormatException e) {
                System.out.println("Повторите попытку, значение не попадает под запрашиваемые параметры");
            }
        }
    }

    private static Long askCoordinateY() {
        while (true) {
            System.out.print("Введите Coordinate Y (тип: long, не может быть null): ");
            try {
                return Long.parseLong(ConsoleManager.getUserPrint());
            } catch (NumberFormatException e) {
                System.out.println("Повторите попытку, значение не попадает под запрашиваемые параметры");
            }
        }
    }

    private static String askPersonName() {
        while (true) {
            try {
                System.out.print("Введите GroupAdmin name (тип: String): ");
                String PersonName = ConsoleManager.getUserPrint();
                if (PersonName.isEmpty()) throw new IllegalArgumentException("Это значение не может быть пустым");
                else return PersonName;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    private static Long askStudentsCount() {
        while (true) {
            try {
                System.out.print("Введите studentsCount (тип: long, больше 0): ");
                Long studentsCount = Long.parseLong(ConsoleManager.getUserPrint());
                if (studentsCount > 0) return studentsCount;
                else throw new IllegalArgumentException("Введено что-то не то. Повторите попытку.");
            } catch (NumberFormatException e) {
                System.out.println("Повторите попытку, значение не попадает под запрашиваемые параметры");
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }
    private static Integer askTransferredStudents() {
        while (true) {
            try {
                System.out.print("Введите transferredStudents (тип: Integer): ");
                String inputTransferredStudents = ConsoleManager.getUserPrint();
                if (inputTransferredStudents.isEmpty()) return 0; // проверять чтобы в коллекции потом хранилась "" а не 0!!
                else if (Integer.parseInt(inputTransferredStudents) > 0) return Integer.parseInt(inputTransferredStudents);
            } catch (NumberFormatException e) {
                System.out.println("Повторите попытку, данное численное значение не попадает под запрашиваемые параметры");
            }
        }
    }
    private static FormOfEducation askFormOfEducationName() {
        while (true) {
            try {
                System.out.println("Введите formOfEducation (тип: String, варианты:\n" +
                        "    DISTANCE_EDUCATION,\n" +
                        "    FULL_TIME_EDUCATION,\n" +
                        "    EVENING_CLASSES)");
                FormOfEducation formOfEducation = Enum.valueOf(FormOfEducation.class, ConsoleManager.getUserPrint().toUpperCase());
                return formOfEducation;
            } catch (IllegalArgumentException e) {
                System.out.println("Повторите попытку, введённое значение не является запрашиваемым Enum");
            }
        }
    }

    private static Semester askSemester() {
        while (true) {
            try {
                System.out.println("Введите Semester (тип: Semester, варианты: \n" +
                        "    FIRST,\n" +
                        "    THIRD,\n" +
                        "    FIFTH,\n" +
                        "    EIGHTH;)");
                Semester semester = Enum.valueOf(Semester.class, ConsoleManager.getUserPrint().toUpperCase());
                return semester;
            } catch (IllegalArgumentException e) {
                System.out.println("Повторите попытку, введённое значение не является запрашиваемым Enum");
            }
        }
    }

    private static double askPersonWeight() {
        while (true) {
            try {
                System.out.print("Введите groupAdmin weight (тип: double, больше 0): ");
                Double weight = Double.parseDouble(ConsoleManager.getUserPrint());
                if (weight > 0) { return weight; }
                else throw new IllegalArgumentException("Введено что-то не то. Повторите попытку.");
            } catch (NumberFormatException e) {
                System.out.println("Повторите попытку, значение не попадает под запрашиваемые параметры");
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    private static String askPersonPassportID() {
        while (true) {
            try {
                System.out.print("Введите groupAdmin passportID (тип: String): ");
                var userPrint = ConsoleManager.getUserPrint();
                if (userPrint.isEmpty()) throw new IllegalArgumentException("Значение passportID не должно быть пустым");
                else return userPrint;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }
    private static Location askPersonLocation() {
        Location location = new Location(askLocationX(), askLocationY(), askLocationZ(), askLocationName());
        return location;
    }
    private static Long askLocationX() {
        while (true) {
            try {
                System.out.print("Введите Location X (тип: Long): ");
                return Long.parseLong(ConsoleManager.getUserPrint());
            } catch (IllegalArgumentException e) {
                System.out.println("Повторите попытку, значение не попадает под запрашиваемые параметры");
            }
        }
    }
    private static float askLocationY() {
        while (true) {
            try {
                System.out.print("Введите Location Y (тип: float): ");
                String location = ConsoleManager.getUserPrint();
                if (location.isEmpty()) return 0;//сделать так, чтобы сохранялся не 0 а пустая строка!!
                else return Float.parseFloat(location);
            } catch (IllegalArgumentException e) {
                System.out.println("Повторите попытку, значение не попадает под запрашиваемые параметры");
            }
        }
    }
    private static Long askLocationZ() {
        while (true) {
            try {
                System.out.print("Введите Location Z (тип: Long): ");
                return Long.parseLong(ConsoleManager.getUserPrint());
            } catch (IllegalArgumentException e) {
                System.out.println("Повторите попытку, значение не попадает под запрашиваемые параметры");
            }
        }
    }
    private static String askLocationName() {
        while (true) {
            try {
                System.out.print("Введите Location name (тип: String): ");
                String outputLocationName = ConsoleManager.getUserPrint();
                if (outputLocationName.isEmpty()) {
                    throw new IllegalArgumentException("Значение Location name не должно быть пустым");
                } else return outputLocationName;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }
}
