package pl.pwr.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.pwr.user.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class UserRepository {

  private static final Logger LOGGER = Logger.getLogger(UserRepository.class.getName());
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  private final String databasePath;
  private final Map<String, User> database = new HashMap<>();

  public UserRepository(String databasePath) {this.databasePath = databasePath;}

  public void loadDatabase(){
    try {
      Map<String, User> users =
          GSON.fromJson(GSON.newJsonReader(new FileReader(databasePath)), Map.class);

      if (users != null) {
        LOGGER.info("Loaded users from path " + databasePath);
        LOGGER.info(users.toString());

        database.putAll(users);
      }
    } catch (FileNotFoundException e) {
      LOGGER.info("Database file does not exist");
    }
  }

  public void saveDatabase() throws IOException {
    LOGGER.info("Saving database to file=" + databasePath);
    LOGGER.info(database.toString());

    try(Writer writer = new FileWriter(databasePath)) {
      writer.write(GSON.toJson(database));
    }
  }

  public void add(User user) {
    database.put(user.getUsername(), user);
  }
}
