package racecondition.counters;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Counter {
    
    private int count = 0;

    private Lock lock = new ReentrantLock();
    
    public int getCounter() {
        return count;
    }

    public void increment() {
        lock.lock();
        try {
            count++;
        } catch (Exception ignored) {
        } finally {
            lock.unlock();
        }
    }
}
