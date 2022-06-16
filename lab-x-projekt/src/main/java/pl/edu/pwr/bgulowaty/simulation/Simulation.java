package pl.edu.pwr.bgulowaty.simulation;

import pl.edu.pwr.bgulowaty.simulation.stats.SimulationStats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Simulation {

  private final Map<SimulationField, Unit> entityByField = new HashMap<>();
  private final Set<Action> availableActions;
  private final int numberOfTurns;

  public Simulation(Set<Action> availableActions, int numberOfTurns) {
    this.availableActions = availableActions;
    this.numberOfTurns = numberOfTurns;
  }

  public SimulationStats run() {
    int currentTurn = 0;
    while (thereAreUnitsFromDifferentTeams() && currentTurn != numberOfTurns) {

      Action actionToApply = pickRandomAction();
      SimulationState simulationState = getSimulationState();

      if (actionToApply.isPossible(simulationState)) {
        SimulationState newState = actionToApply.apply(simulationState);
        applyNewState(newState);
      }
    }

    return new SimulationStats(null); // compute some stats along the way
  }

  Action pickRandomAction() {
    return null; // random Action
  }

  void applyNewState(SimulationState state) {
    entityByField.putAll(state.getEntityByField());
  }

  SimulationState getSimulationState() {
    return new SimulationState(entityByField);
  }

  private boolean thereAreUnitsFromDifferentTeams() {
    return entityByField.values()
        .stream()
        .map(Unit::getTeam)
        .collect(Collectors.toSet())
        .size() > 1;
  }
}
