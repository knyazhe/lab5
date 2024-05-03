package model;

public class Coordinates {
    private Double x; //Поле не может быть null
    private Double y; //Поле не может быть null

    public Coordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
