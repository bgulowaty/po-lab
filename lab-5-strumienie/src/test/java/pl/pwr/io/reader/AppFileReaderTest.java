package pl.pwr.io.reader;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

class AppFileReaderTest {

    private static String getAbsolutePathForTestResource(String resourcePath) throws URISyntaxException {
        return Paths.get(AppFileReaderTest.class.getResource(resourcePath).toURI()).toAbsolutePath().toString();
    }

    @Test
    void shouldReadFileCorrectly() throws IOException, URISyntaxException {
        // given
        String testFilePath = getAbsolutePathForTestResource("/input-test-file.txt");
        AppFileReader reader = AppFileReader.forFile(testFilePath);

        // when
        List<InputRow> actualRows = reader.read();

        // then
        Assertions.assertThat(actualRows).isEqualTo(List.of(
                new InputRow("http://wp.pl", "wojna"),
                new InputRow("http://kssk.pwr.edu.pl", "profesor")
        ));
    }
}