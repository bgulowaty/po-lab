package pl.pwr.io.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class AppFileReader {

  private AppFileReader(String filePath) {
    // implement me
  }

  // implement me
  public static AppFileReader forFile(String path) {
    return new AppFileReader(path);
  }

  public List<InputRow> read() throws URISyntaxException, IOException {
    // implement me

    return List.of();
  }
}
