package knowledge.concurrency.synchronized_wallet;

import java.time.LocalTime;
import java.util.Random;

public class WalletPracticeThread {
    private int totalMoneyInWallet = 0;

    private synchronized Integer getClientMoney(int money) {
        System.out.println(Thread.currentThread().getName() + " : khach hang dua " + money);
        totalMoneyInWallet += money;
        System.out.println(Thread.currentThread().getName() + " : so tien trong vi la " + totalMoneyInWallet + " TIME "
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
                    Thread.currentThread().interrupt();
                }

            }, "cashier-" + i);
            cashier.start();
        }
    }
}
