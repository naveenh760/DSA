package math.number.system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberSytemConverterTest {

    @Test
    void binaryToDecimalTest() {
        String input = "100";
        int actual = NumberSytemConverter.ToDecimal(input,2);
        Assertions.assertEquals(Integer.parseInt(input,2),actual);
    }

    @Test
    void HexToDecimalTest(){
        String input = "1A";
        int actual = NumberSytemConverter.ToDecimal(input, 16);
        Assertions.assertEquals(Integer.parseInt(input,16),actual);
    }


    @Test
    void decimalToBinaryTest() {
        int input = 10;
        String actual = NumberSytemConverter.toBinaryString(input);
        Assertions.assertEquals(Integer.toBinaryString(input),actual);
    }
}