package calculator.model.validator;

import calculator.model.DelimiterInputData;

public interface Validator {
    void validate();

    DelimiterInputData validatedData();

}
