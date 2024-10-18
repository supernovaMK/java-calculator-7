package calculator.controller;

import calculator.model.Calculate;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final String STARTMESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULTMESSAGE = "결과 : ";


    private StringInput stringInput;


    public void start() {
        System.out.println(STARTMESSAGE);

        stringInput = readInput();

        Calculate calculate = new Calculate(stringInput.numbers());

        Long result = calculate.sum();

        System.out.println(RESULTMESSAGE + result);
    }


    private StringInput readInput() {
        String line = Console.readLine();

        return new StringInput(line);

    }

}
