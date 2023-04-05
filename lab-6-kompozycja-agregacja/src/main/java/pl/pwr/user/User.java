package pl.pwr.user;

import java.util.List;

public class User {

  private final
  String username;

  UserLocation location;
  public String getUsername() {
    return username;
  }

  public User(String username) {
    this.username = username;
  }

  public User(String username, UserLocation userLocation) {
    this.username = username;
    this.location = userLocation;
  }

  void changePassword(String newPassword) {

  }

  private final String password = "wartosc";
}
