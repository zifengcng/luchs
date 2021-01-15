package com.luchs.headfirst.compound.duck;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory factory = new CountingFactory();
        duckSimulator.simulate(factory);
    }

    private void simulate(AbstractDuckFactory factory) {
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redHeadDuck = factory.createRedHeadDuck();
        Quackable goose = new GooseAdapter(new Goose());

        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(goose);

        Quackologist quackologist = new Quackologist();
        flock.registryObserver(quackologist);

        simulate(flock);
        System.out.println("quacks = " + QuackCounter.getNumberOfQuacks());
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
