package server.model;

import client.typeadapters.LocalDateTimeTypeAdapter;
import com.google.gson.annotations.JsonAdapter;

import java.util.LinkedList;

public class MyCollection extends LinkedList<Dragon> {

    @JsonAdapter(LocalDateTimeTypeAdapter.class)
    private final java.time.LocalDateTime initializationDate;

    public MyCollection() {
        super();
        this.initializationDate = java.time.LocalDateTime.now();
    }

    public java.time.LocalDateTime getInitializationDate() {
        return this.initializationDate;
    }
    public String getType(){
        return this.getClass().getSimpleName();
    }
}
