package pl.pwr.io.writer;

import java.io.IOException;
import java.util.List;

public class AppFileWriter {

  private final String filePath;

  private AppFileWriter(String filePath) {
    this.filePath = filePath;
  }

  // implement
  public static AppFileWriter forFile(String path) {
    return new AppFileWriter(path);
  }

  public void write(List<OutputRow> outputRows) throws IOException {

    // implement
  }
}
