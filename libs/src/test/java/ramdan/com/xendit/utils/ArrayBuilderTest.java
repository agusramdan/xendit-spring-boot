package ramdan.com.xendit.utils;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ArrayBuilderTest {
    @Test
    void as() {
        val data0 = "data0";
        val data1 = "data1";
        val data2 = "data2";

        val result = ArrayBuilder.as(data0, data1, data2);

        assertSame(data2, result[2]);

    }
}
