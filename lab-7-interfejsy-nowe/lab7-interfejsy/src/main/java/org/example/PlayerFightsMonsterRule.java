package org.example;

import java.util.List;
import java.util.Map;

public class PlayerFightsMonsterRule implements GameRule {

    @Override
    public Map<GameObject, Room> applyRule(Map<GameObject, Room> currentState, List<Room> hallway) {
        System.out.println("Player fights monster?");
        return currentState;
    }
}
