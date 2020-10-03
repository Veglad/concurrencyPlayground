package racecondition;

import racecondition.counters.Counter;
import racecondition.counters.LockCounter;
import racecondition.counters.PlainCounter;
import racecondition.counters.SynchronizedCounter;

import java.util.Arrays;
import java.util.List;

public class RaceCondition {

    public static void main(String[] args) {
        List<Counter> countersPipe = Arrays.asList(
                new PlainCounter(),
                new SynchronizedCounter(),
                new LockCounter()
        );

        ParallelIncrementor incrementor = new ParallelIncrementor();
        countersPipe.forEach(incrementor::parallelIncrement);
        incrementor.shotDown();
    }
}
