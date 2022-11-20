package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    public void parserTest() {
        String[] testArgs = {"f", "X"};
        try{
            MoveDirection[] directions = new OptionsParser().parse(testArgs);
            Assertions.fail("Arguments are invalid");
        }catch(IllegalArgumentException ex){
            Assertions.assertTrue(true);
        }
    }
}
