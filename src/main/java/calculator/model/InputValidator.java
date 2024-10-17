package calculator.model;

public class InputValidator {

    private String input;
    private String bodyInput;
    private Character customDelimiter;

    public InputValidator(String input) {
        this.input = input;
        this.bodyInput = input;
        if (!input.isEmpty()) {
            validate();
        }
    }

    protected void validate() {
        checkCustomDelimiterValidate();
        checkWrongWordValidate();
    }


    private void checkCustomDelimiterValidate() {
        if (input.matches("^//.\\\\n.*")) {

            checkCustomDelimiterRules(input.charAt(2));
            customDelimiter = input.charAt(2);
            bodyInput = input.substring(5);
        }
    }

    private void checkCustomDelimiterRules(Character input) {
        if (input == DelimiterInputData.COLON || input == DelimiterInputData.COMMA) {
            throw new IllegalArgumentException("기본 연산자는 커스텀 연산자로 사용할 수 없습니다.");
        }
        if (input >= '0' && input < '9') {
            throw new IllegalArgumentException("구분자의 문자는 숫자가 될 수 없습니다.");
        }
    }

    private void checkWrongWordValidate() {
        for (int i = 0; i < bodyInput.length(); i++) {
            char ch = bodyInput.charAt(i);

            if ((ch < '1' || ch > '9')
                    && ch != DelimiterInputData.COMMA
                    && ch != DelimiterInputData.COLON
                    && (customDelimiter == null || ch != customDelimiter)) {

                throw new IllegalArgumentException("구분자와 숫자 이외의 문자가 포함된 잘못 된 입력입니다.");
            }

        }
    }


    public DelimiterInputData validated() {

        return new DelimiterInputData(customDelimiter, bodyInput);
    }
}




