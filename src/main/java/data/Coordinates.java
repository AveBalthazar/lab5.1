package data;

/**
 * Объекты, которые используются в StudyGroup.
 */
public class Coordinates {
    private long x;
    private Long  y; //Поле не может быть null

    public Coordinates(long x, Long  y) {
        try {
            this.x = x;
            if (y == null) {
                throw new NullPointerException();
            } else this.y = y;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public long getX() {
        return x;
    }
    public Long getY() {
        return y;
    }
    public  String toString() {
        return "Coordinate x: " + x + ", Coordinate y: " + y;
    }
}
