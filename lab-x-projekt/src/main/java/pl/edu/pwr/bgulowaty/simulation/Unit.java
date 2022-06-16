package pl.edu.pwr.bgulowaty.simulation;

import pl.edu.pwr.bgulowaty.simulation.SimulationField.FieldType;

public interface Unit {

  UnitType getType();

  UnitTeam getTeam();

  UnitSpecie getSpecie();

  int calculateFightFactor(Unit opponent, FieldType fieldType);

  enum UnitSpecie {HUMAN, ALIEN}

  enum UnitType {RUNNER, FIGHTER}
}
