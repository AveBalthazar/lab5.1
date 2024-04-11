package data;

public class Location {
    private Long x; //Поле не может быть null
    private float y;
    private Long z; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле не может быть null
    public Location(Long x, float y, Long z, String name) {
        try {
            if (x == null || z == null || name == null) {
                throw new NullPointerException();
            } else {
                this.x = x;
                this.y = y;
                this.z = z;
                this.name = name;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    public Long askLocationToX() {
        return this.x;
    }
    public String toString() {
        return x.toString() + "," + y + "," + z.toString() + "," + name;
    }
    public void updateLocation(Long x, float y, Long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
}
