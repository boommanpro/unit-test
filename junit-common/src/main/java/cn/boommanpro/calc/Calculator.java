package cn.boommanpro.calc;


/**
 * Calculator
 *
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/5/23
 * @from https://github.com/junit-team/junit4/wiki/Getting-started
 * @since 1.0.0
 */
public class Calculator {
    public int evaluate(String expression) {
        int sum = 0;
        for (String summand: expression.split("\\+")) {
            sum += Integer.valueOf(summand);
        }
        return sum;
    }
}
