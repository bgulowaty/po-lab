package pl.pwr.user;

import java.util.ArrayList;
import java.util.List;

public class User {
  String username;
  private final String someArbitraryField = "abc";
  private UserLocation userLocation;

  public List<Friend> friends = List.of(new Friend("michal", "b"));
  public String getUsername() {
    return username;
  }

  public User(String username) {this.username = username;}

  public User(String username, UserLocation userLocation) {
    this.username = username;
    this.userLocation = userLocation;
  }

  void changePassword(User changer, String newPassword) {

  }
}
