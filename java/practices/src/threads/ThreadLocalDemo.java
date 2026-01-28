package practices.src.threads;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// public class ThreadLocalDemo {
//     private ThreadLocal<Integer> totalMoneyInWall = new ThreadLocal<Integer>() {
//         @Override
//         protected Integer initialValue() {
//             return 0;
//         }
//     };

//     private int getMoney(int money) {

//         System.out.println(Thread.currentThread().getName() + " :khách hàng đưa " + money);
//         int currentTotalMoneyInWallet = totalMoneyInWall.get();
//         totalMoneyInWall.set(currentTotalMoneyInWallet + money);
//         System.out
//                 .println(Thread.currentThread().getName() + " :số tiền trong ví là " + totalMoneyInWall.get() + " TIME "
//                         + LocalTime.now());
//         return money;
//     }

//     public static void main(String[] args) {
//         ThreadLocalDemo demo = new ThreadLocalDemo();
//         ExecutorService threadPool = Executors.newFixedThreadPool(10);

//         for (int i = 0; i < 100; i++) {
//             threadPool.submit(() -> {
//                 demo.getMoney(new Random().nextInt(100));
//                 try {
//                     Thread.sleep(2 * 1000);
//                 } catch (InterruptedException e) {
//                     Thread.interrupted();
//                 }
//                 demo.getMoney(new Random().nextInt(100));
//             }, "cashier" + i);
//         }
//     }
// }

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    private static final ConcurrentHashMap<String, Integer> totals = new ConcurrentHashMap<>();
    private static ThreadLocal<Integer> totalMoneyInWall = ThreadLocal.withInitial(() -> 0);

    private static int getMoney(int money) {
        String cashier = Thread.currentThread().getName();

        System.out.println(Thread.currentThread().getName() + " :khách hàng đưa " + money);

        totalMoneyInWall.set(totalMoneyInWall.get() + money);

        totals.merge(cashier, money, Integer::sum);

        System.out
                .println(Thread.currentThread().getName() + " :số tiền trong ví là " + totalMoneyInWall.get() + " TIME "
                        + LocalTime.now());
        return money;
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10, new ThreadFactory() {
            private int counter = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "cashier-" + counter++);
            }
        });

        for (int i = 0; i < 100; i++) {
            threadPool.submit(() -> {
                getMoney(new Random().nextInt(100));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {
                } finally {
                    totalMoneyInWall.remove();
                }
                getMoney(new Random().nextInt(100));
            });
        }

        try {
            threadPool.shutdown();
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("\n=== Tổng tiền mỗi cashier ===");
            totals.forEach((cashier, total) -> System.out.println(cashier + " = " + total));
            System.out.println("\n=== Tổng tiền ===");
            System.out.println(totals.values().stream().mapToInt(Integer::intValue).sum());
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

    }
}
