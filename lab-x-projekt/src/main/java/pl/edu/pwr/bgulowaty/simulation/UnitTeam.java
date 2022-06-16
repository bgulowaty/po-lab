package pl.edu.pwr.bgulowaty.simulation;


import java.util.UUID;

public class UnitTeam {
  private final String identifier;

  public UnitTeam(String identifier) {this.identifier = identifier;}

  static UnitTeam createNew() {
    return new UnitTeam(UUID.randomUUID().toString());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    UnitTeam unitTeam = (UnitTeam) o;

    return identifier != null ? identifier.equals(unitTeam.identifier)
                              : unitTeam.identifier == null;
  }

  @Override
  public int hashCode() {
    return identifier != null ? identifier.hashCode() : 0;
  }

}
