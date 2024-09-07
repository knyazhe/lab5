package server.model;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class MyCollection extends LinkedList<Dragon> {
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
