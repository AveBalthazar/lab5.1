package data;

public enum Semester {
    FIRST("Первый"),
    THIRD("Третий"),
    FIFTH("Пятый"),
    EIGHTH("Восьмой");
    public String name;
    Semester(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }
}