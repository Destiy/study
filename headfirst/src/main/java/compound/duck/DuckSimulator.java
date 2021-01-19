package compound.duck;

import compound.duck.adapter.Goose;
import compound.duck.adapter.GooseAdapter;
import compound.duck.compound.Flock;
import compound.duck.decorate.QuackCounter;
import compound.duck.factory.CountingDuckFactory;
import compound.duck.observer.Quackologist;
import strategy.duck.behavior.impl.Quack;

/**
 * @author wy
 * @date 2020/11/19
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        CountingDuckFactory duckFactory = new CountingDuckFactory();
//        duckSimulator.simulator(duckFactory);

        duckSimulator.observer(duckFactory);
    }

    private void simulator(CountingDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redhaedDuck = duckFactory.createRedhaedDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());

        this.flockQuck(duckFactory, mallardDuck, redhaedDuck, duckCall, rubberDuck);

        System.out.println("\nDuck simulator");
        simulator(mallardDuck);
        simulator(redhaedDuck);
        simulator(duckCall);
        simulator(rubberDuck);
        simulator(goose);

        System.out.println("The duck quacked " + QuackCounter.numberOfQuack + " times");
    }

    private void flockQuck(CountingDuckFactory duckFactory, Quackable mallardDuck, Quackable redhaedDuck, Quackable duckCall, Quackable rubberDuck) {
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redhaedDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardDuck1 = duckFactory.createMallardDuck();
        Quackable mallardDuck2 = duckFactory.createMallardDuck();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable mallardDuck4 = duckFactory.createMallardDuck();
        flockOfMallards.add(mallardDuck1);
        flockOfMallards.add(mallardDuck2);
        flockOfMallards.add(mallardDuck3);
        flockOfMallards.add(mallardDuck4);

        flockOfDucks.add(flockOfMallards);
        System.out.println("\nDuck simulator: whole flock simulation");
        this.simulator(flockOfDucks);
        System.out.println("\nDuck simulator: mallard flock simulation");
        this.simulator(flockOfMallards);
    }

    private void observer(CountingDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable duckCall = duckFactory.createDuckCall();

        Flock flock = new Flock();
        flock.add(duckFactory.createRubberDuck());
        flock.add(duckFactory.createRedhaedDuck());
        System.out.println("\nDuck: with Observer");
        Quackologist quackologist = new Quackologist();
        flock.registerObserver(quackologist);
        mallardDuck.registerObserver(quackologist);
        duckCall.registerObserver(quackologist);

        this.simulator(flock);
        this.simulator(mallardDuck);
        this.simulator(duckCall);

        System.out.println("count : " +QuackCounter.numberOfQuack);
    }
    private void simulator(Quackable quackable) {
        quackable.quack();
    }
}
