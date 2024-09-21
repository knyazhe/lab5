package server.model;

import client.typeadapters.*;
import com.google.gson.annotations.JsonAdapter;
import server.model.enums.Color;
import server.model.enums.DragonCharacter;

public final class DragonFields {
    @JsonAdapter(LongTypeAdapter.class)
    private Long id; // $$$$ Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @JsonAdapter(StringTypeAdapter.class)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonAdapter(CoordinatesTypeAdapter.class)
    private Coordinates coordinates; //Поле не может быть null
    @JsonAdapter(LocalDateTimeTypeAdapter.class)
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически $$$$
    @JsonAdapter(IntTypeAdapter.class)
    private int age; //Значение поля должно быть больше 0
    @JsonAdapter(BooleanTypeAdapter.class)
    private Boolean speaking; //Поле может быть null ####
    @JsonAdapter(ColorTypeAdapter.class)
    private Color color; //Поле не может быть null
    @JsonAdapter(DragonCharacterTypeAdapter.class)
    private DragonCharacter character; //Поле может быть null ####
    @JsonAdapter(DragonHeadTypeAdapter.class)
    private DragonHead head;
}
