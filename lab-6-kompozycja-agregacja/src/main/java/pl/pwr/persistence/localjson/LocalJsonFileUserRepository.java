package pl.pwr.persistence.localjson;

import pl.pwr.persistence.UserRepository;
import pl.pwr.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LocalJsonFileUserRepository implements UserRepository {

  private static final Logger LOGGER = Logger.getLogger(LocalJsonFileUserRepository.class.getName());

  private final Map<String, User> database;

  public LocalJsonFileUserRepository(Map<String, User> database) {
    this.database = new HashMap<>(database);
  }


  public Map<String, User> getDatabase() {
    return database;
  }

  public void add(User user) {
    database.put(user.getUsername(), user);
  }

  @Override
  public void persist(User user) {
    database.put(user.getUsername(), user);
  }

  @Override
  public void remove(String username) {

  }
}
