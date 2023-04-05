package pl.pwr.app;

import pl.pwr.user.User;

import java.util.List;

public class AppArg {
  public String repositoryPath;
  List<User> users;

  @Override
  public String toString() {
    return "ApplicationArguments{" +
        "repositoryPath='" + repositoryPath + '\'' +
        ", users=" + users +
        '}';
  }

  public AppArg(String repositoryPath) {this.repositoryPath = repositoryPath;}
}
