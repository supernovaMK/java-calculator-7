package calculator.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculateTest {


    @Test
    void sum_간단한_덧셈() {
        // given
        List<Long> numbers = List.of(2L, 3L, 4L, 5L);
        Calculate calculate = new Calculate(numbers);

        // when
        Long result = calculate.sum();

        // then
        assertEquals(14L, result);

    }


}