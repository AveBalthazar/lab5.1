package data;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Строка не может быть пустой, Поле может быть null
    private Location location; //Поле может быть null
    public Person(String name, double weight, String passportID, Location location) {
        try {
            if (name == null || name == "") { throw new IllegalArgumentException("name incorrect");}
            else { this.name = name; }
            if (weight <= 0) { throw new IllegalArgumentException("weight incorrect");}
            else { this.weight = weight; }
            if (passportID == "") {throw new IllegalArgumentException("passportID incorrect");}
            else if (passportID == null) {this.passportID = "null";}
            else {this.passportID = passportID;}
            if (location == null) {throw new NullPointerException();}
            else {this.location = location;}
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.toString());
        }
    }
    @Override
    public String toString() {
        return name + "," + weight + "," + passportID + "," + location;
    }
}