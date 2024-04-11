package data;

/**
 * Объекты, которые используются в StudyGroup
 */
public enum FormOfEducation {
    DISTANCE_EDUCATION ("Дистанционное обучение"),
    FULL_TIME_EDUCATION("Очное обучение"),
    EVENING_CLASSES("Вечернее обучение");
    public String name;
    FormOfEducation(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }
}

