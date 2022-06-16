package pl.edu.pwr.bgulowaty.simulation.unit;

import pl.edu.pwr.bgulowaty.simulation.Unit;
import pl.edu.pwr.bgulowaty.simulation.UnitTeam;

public abstract class UnitBase implements Unit {

  private final UnitTeam team;

  protected UnitBase(UnitTeam team) {this.team = team;}

  @Override
  public UnitTeam getTeam() {
    return team;
  }
}
