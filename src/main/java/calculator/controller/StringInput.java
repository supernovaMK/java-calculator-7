package calculator.controller;

import calculator.model.DelimiterInputData;
import calculator.model.InputValidator;
import calculator.model.SortNumbers;
import java.util.List;

public class StringInput {

    private SortNumbers sortNumbers;

    public StringInput(String input) {

        InputValidator inputValidator = new InputValidator(input);

        DelimiterInputData delimiterInputData = inputValidator.validated();

        sortNumbers = new SortNumbers(delimiterInputData);

    }

    public List<Long> numbers() {

        return sortNumbers.findNumbers();
    }
}
