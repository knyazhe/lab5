package server.model;

import client.typeadapters.*;
import com.google.gson.annotations.JsonAdapter;
import server.model.enums.Color;
import server.model.enums.DragonCharacter;

import java.time.LocalDateTime;

public class Dragon {

//    @JsonAdapter(LongTypeAdapter.class)
    private Long id; // $$$$ Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
//    @JsonAdapter(StringTypeAdapter.class)
    private String name; //Поле не может быть null, Строка не может быть пустой
//    @JsonAdapter(CoordinatesTypeAdapter.class)
    private Coordinates coordinates; //Поле не может быть null
    @JsonAdapter(LocalDateTimeTypeAdapter.class)
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически $$$$
//    @JsonAdapter(IntTypeAdapter.class)
    private int age; //Значение поля должно быть больше 0
//    @JsonAdapter(BooleanTypeAdapter.class)
    private Boolean speaking; //Поле может быть null ####
//    @JsonAdapter(ColorTypeAdapter.class)
    private Color color; //Поле не может быть null
//    @JsonAdapter(DragonCharacterTypeAdapter.class)
    private DragonCharacter character; //Поле может быть null ####
//    @JsonAdapter(DragonHeadTypeAdapter.class)
    private DragonHead head;

    public Dragon(int age, DragonCharacter character, Color color, Coordinates coordinates, LocalDateTime creationDate, DragonHead head, Long id, String name, Boolean speaking) {
        this.age = age;
        this.character = character;
        this.color = color;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.head = head;
        this.id = id;
        this.name = name;
        this.speaking = speaking;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public Color getColor() {
        return color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public DragonHead getHead() {
        return head;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Boolean getSpeaking() {
        return speaking;
    }

    public void setSpeaking(Boolean speaking) {
        this.speaking = speaking;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", speaking=" + speaking +
                ", color=" + color +
                ", character=" + character +
                ", head=" + head +
                '}';
    }
}
