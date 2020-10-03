package racecondition.counters;

public class SynchronizedCounter implements Counter {
    
    private int count = 0;
    
    public int getCounter() {
        return count;
    }

    synchronized public void increment() {
        count++;
    }
}
