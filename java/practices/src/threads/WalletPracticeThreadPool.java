package practices.src.threads;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WalletPracticeThreadPool {
    private int totalMoneyInWallet = 0;

    private synchronized Integer getClientMoney(int money) {
        System.out.println(Thread.currentThread().getName() + " :khách hàng đưa " + money);
        totalMoneyInWallet += money;
        System.out.println(Thread.currentThread().getName() + " :số tiền trong ví là " + totalMoneyInWallet + " TIME "
                + LocalTime.now());
        return money;
    }

    public static void main(String[] args) {
        // ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // WalletPracticeThreadPool walletPractice = new WalletPracticeThreadPool();
        // for (int i = 0; i < 100; i++) {
        // threadPool.submit(() -> {
        // walletPractice.getClientMoney(new Random().nextInt(100));
        // }, "cashier" + i);
        // // threadPool.execute(() -> {
        // // walletPractice.getClientMoney(new Random().nextInt(100));
        // // });
        // }
        Object bow = new Object();
        Object arrow = new Object();
        

        ExecutorService archery = Executors.newFixedThreadPool(2);

        archery.submit(() -> {
            synchronized (bow) {
                System.out.println(Thread.currentThread().getName() + "PER1 : người có cung -> đợi mũi tên từ PER2");
                // try {
                // Thread.sleep( 100);
                // } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                // }
                synchronized (arrow) {
                    System.out.println(Thread.currentThread().getName() + "PER1 : đã đủ -> bắn mũi tên");
                }
            }
        });

        archery.submit(() -> {
            synchronized (arrow) {
                System.out.println(Thread.currentThread().getName() + "PER2 : người có mũi tên -> đợi cung từ PER1");
                // try {
                // Thread.sleep( 100);
                // } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                // }
                synchronized (bow) {
                    System.out.println(Thread.currentThread().getName() + "PER2 : đã đủ -> bắn cung");
                }
            }
        });
    }
}
