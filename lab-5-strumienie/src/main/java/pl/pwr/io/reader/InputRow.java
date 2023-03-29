package pl.pwr.io.reader;

import java.util.Objects;

public class InputRow {
  private final String address;
  private final String word;

  InputRow(String address, String word) {
    this.address = address;
    this.word = word;
  }

  public String getAddress() {
    return address;
  }

  public String getWord() {
    return word;
  }

  @Override
  public String toString() {
    return "Row{" +
            "address='" + address + '\'' +
            ", word='" + word + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InputRow inputRow = (InputRow) o;
    return Objects.equals(address, inputRow.address) && Objects.equals(word, inputRow.word);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, word);
  }
}
