package calculator.model;

public enum DefaultDelimiter {

    COMMA(','),
    COLON(':');

    private final char delimiter;

    public char getDelimiter() {
        return delimiter;
    }

    DefaultDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }
}
