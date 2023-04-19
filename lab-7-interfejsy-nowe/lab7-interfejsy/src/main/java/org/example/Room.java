package org.example;

public class Room {

    private final String name;

    public String getName() {
        return name;
    }

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }
}
