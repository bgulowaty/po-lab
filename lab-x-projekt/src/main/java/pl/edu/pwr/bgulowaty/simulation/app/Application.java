package pl.edu.pwr.bgulowaty.simulation.app;

import pl.edu.pwr.bgulowaty.simulation.Simulation;
import pl.edu.pwr.bgulowaty.simulation.stats.SimulationStats;

public class Application {

  public static void main(String[] args) {
    ArgumentsParser argumentsParser = new ArgumentsParser(args);

    SimulationArguments arguments = argumentsParser.parse();

    SimulationStats stats = createAndRunSimulation(arguments);

    printStats(stats);
  }

  private static SimulationStats createAndRunSimulation(SimulationArguments arguments) {
    SimulationCreator simulationCreator = new SimulationCreator(arguments);
    Simulation simulation = simulationCreator.create();
    SimulationStats stats = simulation.run();
    return stats;
  }

  private static void printStats(SimulationStats stats) {

  }
}
