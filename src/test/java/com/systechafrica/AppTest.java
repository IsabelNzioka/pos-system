package com.systechafrica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)  //? default instance
public class AppTest {


    @Test
    void add() {
        // when
        int result = 2 + 3;
        // then
        int expected = 5;
        // verify thst result = expected
        Assertions.assertEquals(expected, result, " The sum of 2 + 3 should be 5");

    }


}
