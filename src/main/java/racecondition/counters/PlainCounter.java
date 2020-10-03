package racecondition.counters;

public class PlainCounter implements Counter {

    private int count = 0;

    public int getCounter() {
        return count;
    }

    public void increment() {
        count++;
    }
}
