package calculator.model;

import java.util.List;

public class Calculate {
    List<Long> numbers;

    public Calculate(StringInput stringInput) {
        this.numbers = stringInput.numbers;
    }

    public long sum() {
        return numbers.stream().mapToLong(Long::longValue).sum();

    }
}
