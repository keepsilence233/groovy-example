package qx.leizige.groovy.example;

import org.springframework.stereotype.Component;

@Component
public class DefaultCalculatorImpl implements ICalculator {
    @Override
    public Integer add(int a, int b) {
        return a + b;
    }

    @Override
    public Integer getNumber() {
        return 666;
    }
}
