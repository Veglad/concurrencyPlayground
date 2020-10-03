package racecondition;

import racecondition.counters.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelIncrementor {
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    void parallelIncrement(Counter counter) {
        String counterName = counter.getClass().getName();
        System.out.println(String.format("\nGoing to increment counter <%s>", counterName));

        for (int i = 0; i < 1000; i++) {
            threadPool.submit(counter::increment);
        }

        try {
            threadPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {

        } finally {
            System.out.println(String.format("Final counter <%s> state after 1000 increments - %s", counterName, counter.getCounter()));
        }
    }

    public void shotDown() {
        threadPool.shutdown();
    }
}
