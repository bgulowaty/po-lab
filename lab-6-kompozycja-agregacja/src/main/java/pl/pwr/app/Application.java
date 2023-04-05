package pl.pwr.app;

import pl.pwr.persistence.UserRepository;
import pl.pwr.persistence.localjson.LocalJsonFileRepositoryLoader;
import pl.pwr.user.User;
import pl.pwr.user.UserLocation;

import java.io.IOException;
import java.util.logging.Logger;

public class Application {
  private static Logger LOGGER = Logger.getLogger(Application.class.getName());

  public static void main(String[] args) throws IOException {
    AppArg arguments = parse(args);
    LOGGER.info("Loaded arguments=" + args);

    // load or create repo
    LocalJsonFileRepositoryLoader loader = new LocalJsonFileRepositoryLoader(arguments.repositoryPath);
    UserRepository repo = loader.loadOrCreate();

    repo.persist(new User("Andrzej"));
    UserLocation userLocation = new UserLocation();
    userLocation.lat = "23";
    userLocation.lon = "25";
    repo.persist(new User("Michalina", userLocation));

    // save repo
    loader.save(repo);
  }

  private static AppArg parse(String[] args) {
    String pth = args[0];
    return new AppArg(pth);
  }
}
