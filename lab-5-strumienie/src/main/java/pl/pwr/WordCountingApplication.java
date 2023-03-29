package pl.pwr;

import org.apache.commons.lang3.StringUtils;
import pl.pwr.io.PageDownloader;
import pl.pwr.io.reader.AppFileReader;
import pl.pwr.io.reader.InputRow;
import pl.pwr.io.writer.AppFileWriter;
import pl.pwr.io.writer.OutputRow;
import pl.pwr.wordscounter.WordsCounter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class WordCountingApplication {

  public static void main(String[] args) throws IOException, URISyntaxException {
    AppArguments arguments = validateAndParseArguments(args);

    AppFileReader appFileReader = AppFileReader.forFile(arguments.getInputFilePath());
    List<InputRow> inputFileInputRows = appFileReader.read();

    List<OutputRow> rowsToWrite = new LinkedList<>();
    for (InputRow inputRow : inputFileInputRows) {
      String address = inputRow.getAddress();
      String wordToCount = inputRow.getWord();
      String text = PageDownloader.getText(address);

      int count = WordsCounter.count(text, wordToCount);

      rowsToWrite.add(new OutputRow(address, count));
    }

    AppFileWriter.forFile(arguments.getOutputFilePath()).write(rowsToWrite);
  }

  private static AppArguments validateAndParseArguments(String[] args) {
    checkArgument(args.length == 2, "Program arguments need to contain paths to input and output files");
    String inputFilePath = args[0];
    String outputFilePath = args[1];

    checkArgument(StringUtils.isNotBlank(inputFilePath), "Input file path cannot be blank");
    checkArgument(StringUtils.isNotBlank(outputFilePath), "Output file path cannot be blank");

    return new AppArguments(inputFilePath, outputFilePath);
  }
}
