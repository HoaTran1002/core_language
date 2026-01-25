package practices.src.threads;

import java.time.LocalTime;
import java.util.Random;

public class WalletPracticeThread {
    private int totalMoneyInWallet = 0;

    private synchronized Integer getClientMoney(int money) {
        System.out.println(Thread.currentThread().getName() + " :khách hàng đưa " + money);
        totalMoneyInWallet += money;
        System.out.println(Thread.currentThread().getName() + " :số tiền trong ví là " + totalMoneyInWallet + " TIME "
                + LocalTime.now());
        return money;
    }

    public static void main(String[] args) {
        WalletPracticeThread walletPractice = new WalletPracticeThread();
        for (int i = 0; i < 10; i++) {
            Thread cashier = new Thread(() -> {
                walletPractice.getClientMoney(new Random().nextInt(100));
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }, "cashier" + i);
            cashier.start();
        }

        // WalletPractice walletPractice = new WalletPractice();
        // Thread cashier1 = new Thread(() -> {
        // walletPractice.getClientMoney(new Random().nextInt(100));
        // try {
        // Thread.sleep(2 * 1000);
        // } catch (InterruptedException e) {
        // throw new RuntimeException(e);
        // }
        // walletPractice.getClientMoney(new Random().nextInt(100));

        // }, "cashier1");
        // cashier1.start();

        // Thread cashier2 = new Thread(() -> {
        // walletPractice.getClientMoney(new Random().nextInt(100));
        // try {
        // Thread.sleep(2 * 1000);
        // } catch (InterruptedException e) {
        // throw new RuntimeException(e);
        // }
        // walletPractice.getClientMoney(new Random().nextInt(100));

        // }, "cashier2");
        // cashier2.start();
        // }
    }

}
