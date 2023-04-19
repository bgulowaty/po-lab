package org.example;

import java.util.List;
import java.util.Map;

public class FixedGameState {

    static GameStateHolder get() {
        Room startingRoom = new Room("Starting room");
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");

        List<Room> hallway = List.of(
                startingRoom,
                room1,
                room2,
                room3
        );


        Player player = new Player();

        Monster monster = new Monster();


        return new GameStateHolder(
                hallway,
                Map.of(new Player(), startingRoom,
                        monster, room3)
        );
    }
}
