package pl.edu.pwr.bgulowaty.simulation.unit;

import pl.edu.pwr.bgulowaty.simulation.SimulationField.FieldType;
import pl.edu.pwr.bgulowaty.simulation.Unit;
import pl.edu.pwr.bgulowaty.simulation.UnitTeam;

import java.util.List;
import java.util.Random;

public class SneakyRandomRunner extends UnitBase{
  private static final Random RANDOM = new Random();

  public SneakyRandomRunner(UnitTeam team) {
    super(team);
  }

  @Override
  public UnitType getType() {
    return UnitType.RUNNER;
  }

  @Override
  public UnitSpecie getSpecie() {
    return pickRandomSpecie();
  }

  private static UnitSpecie pickRandomSpecie() {
    return List.of(UnitSpecie.ALIEN, UnitSpecie.HUMAN).get(RANDOM.nextInt(2));
  }

  @Override
  public int calculateFightFactor(Unit opponent, FieldType fieldType) {
    if (fieldType == FieldType.FOREST && opponent.getType() != UnitType.FIGHTER) {
      return 2;
    }

    return 1;
  }
}
