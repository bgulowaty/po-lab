package pl.pwr.io.writer;

import java.util.Objects;

public class OutputRow {
    private final String address;
    private final int count;

    public OutputRow(String address, int count) {
        this.address = address;
        this.count = count;
    }

    String getAddress() {
        return address;
    }

    int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputRow outputRow = (OutputRow) o;
        return count == outputRow.count && Objects.equals(address, outputRow.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, count);
    }
}
