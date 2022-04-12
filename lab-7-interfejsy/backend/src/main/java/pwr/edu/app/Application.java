package pwr.edu.app;

import com.typesafe.config.ConfigFactory;

public class Application {

  public static void main(String[] args) {
    ApplicaitonProperties properties = new ApplicaitonProperties(ConfigFactory.load());

    new ApplicationConfigurer(properties).configure();
  }
}
