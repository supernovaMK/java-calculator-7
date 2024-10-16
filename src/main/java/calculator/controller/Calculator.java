package calculator.controller;

import calculator.Model.StringInput;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final String STARTMESSAGE = "덧셈할 문자열을 입력해 주세요.";


    public void start() {
        System.out.println(STARTMESSAGE);
        StringInput input = readInput();

    }

    private StringInput readInput() {
        String line = Console.readLine();

        return new StringInput(line);
    }


}
