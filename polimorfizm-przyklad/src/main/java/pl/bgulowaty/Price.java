package pl.bgulowaty;

public record Price(
        Double value // not nescessary good approach
) {

    static Price of(Double value) {
        return new Price(value);
    }

}
