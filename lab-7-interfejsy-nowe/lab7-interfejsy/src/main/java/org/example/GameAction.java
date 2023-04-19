package org.example;

import java.util.List;
import java.util.Map;

public interface GameAction {

    Map<GameObject, Room> applyAction(Map<GameObject, Room> currentState, List<Room> hallway);
}
