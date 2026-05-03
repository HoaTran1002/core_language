package knowledge.concurrency.starvation;

import java.util.concurrent.locks.ReentrantLock;

// Demonstrates a thread that struggles to acquire a lock.
public class StarvationDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable greedy = () -> {
            while (true) {
                lock.lock();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } finally {
                    lock.unlock();
                }
            }
        };

        Runnable starving = () -> {
            while (true) {
                if (lock.tryLock()) {
                    try {
                        System.out.println("Starving thread got the lock!");
                        break;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        new Thread(greedy, "Thread-Greedy-1").start();
        new Thread(greedy, "Thread-Greedy-2").start();
        new Thread(starving, "Thread-Starving").start();
    }
}
