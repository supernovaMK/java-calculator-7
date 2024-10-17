package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbers {
    private Character customDelimiter;
    private String input;

    public SortNumbers(DelimiterInputData delimiterInputData) {
        this.customDelimiter = delimiterInputData.getcustomedDelimiter();
        this.input = delimiterInputData.getInput();
    }


    public List<Long> findNumbers() {

        if (input.isEmpty()) {
            return null;
        }

        String reg = makeReqularExpression(customDelimiter);

        return Arrays.stream(input.split(reg))
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private String makeReqularExpression(Character customDelimiter) {
        return "[" + DelimiterInputData.COMMA + DelimiterInputData.COLON + changeExceptionWord(
                String.valueOf(customDelimiter)) + "]";
    }

    private String changeExceptionWord(String str) {

        return str.replace("\\", "\\\\")
                .replace("[", "\\[")
                .replace("]", "\\]")
                .replace(" ", "\\s");

    }

}
