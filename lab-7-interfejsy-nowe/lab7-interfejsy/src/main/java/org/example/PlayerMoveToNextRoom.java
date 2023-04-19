package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class PlayerMoveToNextRoom implements GameAction{

    @Override
    public Map<GameObject, Room> applyAction(Map<GameObject, Room> currentState, List<Room> hallway) {
        GameObject player = currentState.keySet()
                .stream()
                .filter(it -> it instanceof Player)
                .findFirst()
                .orElseThrow();

        Room playerRoom = currentState.get(player);

        int playerRoomIndex = hallway.indexOf(playerRoom);

        if (hallway.size() == playerRoomIndex - 1) {
            System.out.println("Cannot move player - he is in the last room!");
            return currentState;
        }

        else {
            Map<GameObject, Room> newState = new HashMap<>(currentState);

            newState.remove(player);
            Room newPlayerRoom = hallway.get(playerRoomIndex + 1);
            newState.put(player, newPlayerRoom);

            System.out.println("Player moved to room " + newPlayerRoom );
            return newState;
        }
    }
}