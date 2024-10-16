package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringInput {

    private final char COMMA = ',';
    private final char COLON = ':';
    private final String input;
    private String realinput;
    private long length;
    private Character customWord;
    public List<Long> numbers;


    public StringInput(String input) {
        this.input = input;
        this.realinput = input;
        checkLength(input);

        if (length == 0) {
            numbers = List.of(0L);
            return;
        }

        validate();
        findNumber();
    }

    private void checkLength(String input) {
        this.length = (long) input.length();
    }

    private void validate() {
        if (length > 4) {
            checkCustomValidate();
        }
        checkWrongWordValidate();
    }

    private void checkCustomValidate() {
        if ((input.substring(0, 2).equals("//")) && (input.substring(3, 5).equals("\\n"))) {
            customWord = input.charAt(2);
            realinput = input.substring(5);
        }
    }

    private void checkWrongWordValidate() {
        for (int i = 0; i < realinput.length(); i++) {
            char ch = realinput.charAt(i);

            if (ch < '1' || ch > '9') {

                if (ch != COMMA && ch != COLON && (customWord == null || ch != customWord)) {
                    throw new IllegalArgumentException("잘못된 사용입니다.");
                }
            }
        }
    }

    private void findNumber() {
        String customDelimeter = (customWord != null) ? escapeSpecialChars(String.valueOf(customWord)) : "";
        String reg = "[" + COMMA + COLON + customDelimeter + "]";

        numbers = Arrays.stream(realinput.split(reg))
                .filter(x -> x != null)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private String escapeSpecialChars(String str) {

        return str.replace("\\", "\\\\")
                .replace("[", "\\[")
                .replace("]", "\\]");
    }
}
