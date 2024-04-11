package utility;

import data.StudyGroup;
import exception.IdOverflowException;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Класс управляет коллекцией
 */
public class JavaCollectionManager implements CollectionManager {
    /**
     * Свободный номер для уникального id.
     */
    private static int freeNumberForId = 1;
    /**
     * Дата последней инициализации коллекции.
     */
    private static LocalDateTime lastInitTime;
    /**
     * Дата последнего сохранения коллекции.
     */
    private static LocalDateTime saveTime;
    /**
     * Коллекция в которой хранятся {@link StudyGroup}
     */
    private static ArrayList<StudyGroup> studyGroupCollection = new ArrayList<>();
    private static ArrayList<String[]> stringStudyGroupCollection = new ArrayList<>();
    private static CollectionManager COLLECTION_MANAGER = new JavaCollectionManager();
    private FileManager fileManager = FileManager.getInstance();

    public static CollectionManager getInstance() {
        return COLLECTION_MANAGER;
    }

    public static ArrayList<String[]> getStringStudyGroupCollection() {
        return stringStudyGroupCollection;
    }

    /**
     * Метод ищет новое уникальное id
     *
     * @return уникальное id
     */
    public int getFreeNumberForId() {
        while (true) {
            try {
                boolean flag = true;
                if (studyGroupCollection != null) {
                    for (StudyGroup studyGroup : studyGroupCollection) {
                        if (studyGroup.getId() == freeNumberForId) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) {
                    freeNumberForId += 1;
                    if (freeNumberForId < 0) {
                        throw new IdOverflowException();
                    }
                } else {
                    return freeNumberForId;
                }
            } catch (IdOverflowException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Возвращает коллекцию из <b>StudyGroup</b>.
     *
     * @return коллекция из StudyGroup.
     */
    public ArrayList<StudyGroup> getStudyGroupCollection() {
        return studyGroupCollection;
    }

    /**
     * Записывает последнее время сохранения коллекции.
     */
    public void saveTimeCollection() {
        saveTime = LocalDateTime.now();
    }

    /**
     * Возвращает последнюю дату сохранения коллекции.
     *
     * @return Последнюю дату сохранения.
     */
    public LocalDateTime getSaveTimeCollection() {
        return saveTime;
    }

    /**
     * Возвращает последнюю дату инициализации коллекции.
     *
     * @return последнюю дату инициализации.
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * Загружает коллекцию из файла
     */
    public void loadCollection(FileManager fileManager) {
        lastInitTime = LocalDateTime.now();
        fileManager.readCollection();
    }

    /**
     * Очищает коллекцию
     */
    public void clear() {
        studyGroupCollection.clear();
        System.out.println("Коллекция успешно очищена.");
    }

    public void addStringStudyGroupCollection(String[] stringStudyGroup) {
        stringStudyGroupCollection.add(stringStudyGroup);
    }
}
