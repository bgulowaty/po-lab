package org.example;

import java.util.List;
import java.util.Map;

public class GameStateHolder {
    private static List<GameRule> RULES_TO_APPLY_EACH_ACTION = List.of(
        new PlayerFightsMonsterRule()
    );

    private final List<Room> hallway;

    private Map<GameObject, Room> gameMap;


    public GameStateHolder(List<Room> hallway, Map<GameObject, Room> gameMap) {
        this.hallway = hallway;
        this.gameMap = gameMap;
    }

    public void applyGameAction(GameAction gameAction) {
        gameMap = gameAction.applyAction(gameMap, hallway);

        for (GameRule rule: RULES_TO_APPLY_EACH_ACTION) {
            this.gameMap = rule.applyRule(this.gameMap, hallway);
        }
    }

    public boolean playerIsAlive() {
        return true;
    }

    public boolean playerHarReachedFinalRoom() {
        Room lastRoom = hallway.get(hallway.size() - 1);

        return lastRoom.equals(findPlayerRoom());
    }


    Room findPlayerRoom() {
        GameObject player = gameMap.keySet()
                .stream()
                .filter(it -> it instanceof Player)
                .findFirst()
                .orElseThrow();

        return gameMap.get(player);
    }


    @Override
    public String toString() {
        return "GameStateHolder{" +
                "hallway=" + hallway +
                ", gameMap=" + gameMap +
                '}';
    }

}
