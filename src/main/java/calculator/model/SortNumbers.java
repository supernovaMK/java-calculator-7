package calculator.model;

import java.util.Arrays;
import java.util.Collections;
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
            return Collections.emptyList();
        }

        String reg = makeReqularExpression(customDelimiter);
        List<String> extractedStrings = Arrays.stream(input.split(reg))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        validateNumbers(extractedStrings);

        return extractedStrings.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private void validateNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (number.length() > 1) {
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + number);
            }
        }
    }

    private String makeReqularExpression(Character customDelimiter) {
        return "[" + DelimiterInputData.COMMA + DelimiterInputData.COLON + changeExceptionWord(
                String.valueOf(customDelimiter)) + "]";
    }

    private String changeExceptionWord(String str) {

        return str.replace("\\", "\\\\")
                .replace("[", "\\[")
                .replace("]", "\\]");


    }

}
