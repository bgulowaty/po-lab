package pl.pwr.wordscounter;

import org.junit.jupiter.api.Test;
import pl.pwr.common.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsCounterTest {

  @Test
  void givenSamplePage_countsSomeWordCorrectly() {
    Page samplePage = new Page("some page some body");
    WordsCounter underTest = new WordsCounter("some");

    assertEquals(2, underTest.countWordsInPage(samplePage));
  }
}
