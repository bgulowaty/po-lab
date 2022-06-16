package pl.edu.pwr.bgulowaty.simulation;

import java.util.Set;

public class SimulationField {

  private final Set<SimulationField> neighbors;
  private final FieldType fieldType;

  public SimulationField(Set<SimulationField> neighbors, FieldType fieldType) {
    this.neighbors = neighbors;
    this.fieldType = fieldType;
  }

  public enum FieldType {ICE, DESERT, FOREST}
}
