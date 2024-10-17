package calculator.model;

public class StringInput {

    private DefaultInput defaultInput;
    private InputValidator inputValidator;
    private SortNumbers sortNumbers;

    public StringInput(String input) {

        defaultInput = new DefaultInput(input);
        inputValidator = new InputValidator(defaultInput);
        sortNumbers = new SortNumbers(defaultInput);

    }

    public ResultDto result() {
        return new ResultDto(defaultInput.getNumbers());
    }
}
