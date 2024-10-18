package calculator.controller;

import calculator.model.DelimiterInputData;
import calculator.model.SortNumbers;
import calculator.model.validator.InputValidator;
import java.util.List;

public class StringInput {

    private SortNumbers sortNumbers;

    public StringInput(String input) {

        InputValidator inputValidator = new InputValidator(input);

        DelimiterInputData delimiterInputData = inputValidator.validatedData();

        sortNumbers = new SortNumbers(delimiterInputData);

    }

    public List<Long> numbers() {

        return sortNumbers.findNumbers();
    }
}
