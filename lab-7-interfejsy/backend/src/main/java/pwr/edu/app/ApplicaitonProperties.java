package pwr.edu.app;

import com.typesafe.config.Config;

class ApplicaitonProperties {

  private final int port;
  private final String frontendAppClasspath;

  ApplicaitonProperties(Config config) {
    this.port = config.getInt("port");
    this.frontendAppClasspath = config.getString("frontendAppClasspath");
  }

  int getPort() {
    return port;
  }

  String getFrontendAppClasspath() {
    return frontendAppClasspath;
  }
}
