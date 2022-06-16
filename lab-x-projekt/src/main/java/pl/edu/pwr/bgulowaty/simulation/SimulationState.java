package pl.edu.pwr.bgulowaty.simulation;

import java.util.Map;

public class SimulationState {
  private final Map<SimulationField, Unit> entityByField;

  public SimulationState(Map<SimulationField, Unit> entityByField) {
    this.entityByField = entityByField;
  }

  Map<SimulationField, Unit> getEntityByField() {
    return entityByField;
  }
}
