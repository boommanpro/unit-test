package cn.boommanpro.calc;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CalculatorTest
 *
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/5/23
 * @since 1.0.0
 */
public class CalculatorTest {

    @Test
    public void evaluate() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+3");
        assertEquals(6, sum);
    }

}