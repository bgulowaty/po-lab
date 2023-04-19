package org.example;

import java.util.List;
import java.util.Map;

public interface GameRule {

    Map<GameObject, Room> applyRule(Map<GameObject, Room> currentState, List<Room> hallway);
}
