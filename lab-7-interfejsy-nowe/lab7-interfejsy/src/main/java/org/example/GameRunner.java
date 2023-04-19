package org.example;

public class GameRunner {
    private final GameStateHolder gameStateHolder;
    private final GameActionsProvider gameActionsProvider;

    public GameRunner(GameStateHolder gameStateHolder, GameActionsProvider gameActionsProvider) {
        this.gameStateHolder = gameStateHolder;
        this.gameActionsProvider = gameActionsProvider;
    }

    public void run() {
        do {
            GameAction nextAction = gameActionsProvider.next();
            gameStateHolder.applyGameAction(nextAction);
        } while (gameStateHolder.playerIsAlive() && !gameStateHolder.playerHarReachedFinalRoom());
    }
}
