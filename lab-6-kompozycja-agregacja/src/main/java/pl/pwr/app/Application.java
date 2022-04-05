package pl.pwr.app;

import pl.pwr.persistence.UserRepository;
import pl.pwr.user.User;
import pl.pwr.user.UserLocation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

public class Application {
  private static Logger LOGGER = Logger.getLogger(Application.class.getName());

  public static void main(String[] args) throws IOException {
    ApplicationArguments arguments = parse(args);
    LOGGER.info("Loaded arguments=" + args);

    UserRepository userRepository = new UserRepository(arguments.repositoryPath);
    userRepository.loadDatabase();

    userRepository.add(new User("andrzej"));
    UserLocation userLocation = new UserLocation();
    userLocation.lat = "23";
    userLocation.lon = "25";
    userRepository.add(new User("kejt", userLocation));
    userRepository.saveDatabase();
  }

  private static ApplicationArguments parse(String[] args) {
    String repostiryPath = args[0];
    return new ApplicationArguments(repostiryPath);
  }
}
