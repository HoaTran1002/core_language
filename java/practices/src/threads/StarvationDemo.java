package practices.src.threads;

import java.util.concurrent.locks.ReentrantLock;
//Không đủ cơ hội chạy
public class StarvationDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable greedy = () -> {
            while (true) {
                lock.lock();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) { }
                finally {
                    lock.unlock();
                }
            }
        };

        Runnable starving = () -> {
            while (true) {
                try {
                    if (lock.tryLock()) {
                        System.out.println("Starving thread got the lock!");
                        lock.unlock();
                        break;
                    }
                } catch (Exception e) {}
            }
        };

        new Thread(greedy, "Thread-Greedy-1").start();
        new Thread(greedy, "Thread-Greedy-2").start();
        new Thread(starving, "Thread-Starving").start();
    }
}
// ⭐ Tránh Starvation:

// Dùng fair lock (new ReentrantLock(true))

// Tránh high priority bias

// Tránh synchronized dài