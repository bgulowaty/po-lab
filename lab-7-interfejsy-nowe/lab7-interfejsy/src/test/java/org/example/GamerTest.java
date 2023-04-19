package org.example;

import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.List;

class GamerTest {


    @Test
    void playerCanPassTheGameTest() {
        // given
        GameStateHolder initialGameState = FixedGameState.get();
        List<GameAction> performedActions = List.of(
                new PlayerMoveToNextRoom(),
                new PlayerMoveToNextRoom(),
                new PlayerMoveToNextRoom()
        );
        GameRunner runner = new GameRunner(initialGameState, () -> performedActions.iterator().next());


        // when
        runner.run();

        // then
        assert initialGameState.playerHarReachedFinalRoom();
        assert initialGameState.playerIsAlive();
    }
}