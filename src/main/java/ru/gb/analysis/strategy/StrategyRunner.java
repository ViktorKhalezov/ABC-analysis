package ru.gb.analysis.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyRunner {

    private SetPropertyStrategy strategy;

    public void setStrategy(SetPropertyStrategy strategy) {
        this.strategy = strategy;
    }

    public void runStrategy() {
        strategy.setProperty();
    }

}
