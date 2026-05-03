package knowledge.concurrency.thread_pool_deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WalletPracticeThreadPool {
    public static void main(String[] args) {
        Object bow = new Object();
        Object arrow = new Object();

        ExecutorService archery = Executors.newFixedThreadPool(2);

        archery.submit(() -> {
            synchronized (bow) {
                System.out.println(Thread.currentThread().getName() + " PER1: nguoi co cung -> doi mui ten tu PER2");
                synchronized (arrow) {
                    System.out.println(Thread.currentThread().getName() + " PER1: da du -> ban mui ten");
                }
            }
        });

        archery.submit(() -> {
            synchronized (arrow) {
                System.out.println(Thread.currentThread().getName() + " PER2: nguoi co mui ten -> doi cung tu PER1");
                synchronized (bow) {
                    System.out.println(Thread.currentThread().getName() + " PER2: da du -> ban cung");
                }
            }
        });

        archery.shutdown();
    }
}
