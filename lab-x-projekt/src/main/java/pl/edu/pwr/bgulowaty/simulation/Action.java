package pl.edu.pwr.bgulowaty.simulation;

import pl.edu.pwr.bgulowaty.simulation.stats.SimulationStats;

public interface Action {
  boolean isPossible(SimulationState simulationState);

  SimulationState apply(SimulationState currentState);
}
