package pl.pwr.io.writer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class AppFileWriterTest {


    private static Path createSomeTmpFile() throws IOException {
        Path temporaryFilePath = Files.createTempFile("app", "");
        return temporaryFilePath.toAbsolutePath();
    }

    @Test
    void shouldWriteTestFileCorrectly() throws IOException {
        // given
        Path path = createSomeTmpFile();
        String pathAsString = path.toString();
        AppFileWriter writer = AppFileWriter.forFile(pathAsString);
        List<OutputRow> exampleRows = List.of(
                new OutputRow("http://wp.pl", 25),
                new OutputRow("http://google.pl", 10)
        );


        // when
        writer.write(exampleRows);

        // then
        List<String> filesContent = Files.readAllLines(path);
        Assertions.assertThat(filesContent).isEqualTo(List.of(
                "http://wp.pl,25",
                "http://google.pl,10"
        ));
    }
}