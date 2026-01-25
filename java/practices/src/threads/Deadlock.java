package practices.src.threads;
//Chờ tài nguyên nhau
public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                + "  has bowed to me!%n", 
                this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
            new Friend("Alphonse");
        final Friend gaston2 =
            new Friend("Gaston");
        final Friend alphonse2 =
            new Friend("Alphonse");
        final Friend gaston =
            new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();

        new Thread(new Runnable() {
            public void run() { alphonse2.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston2.bow(alphonse); }
        }).start();
    }
}
// ⭐ Tránh Deadlock:

// Dùng thứ tự lock cố định

// Dùng tryLock()

// Dùng timeout

// Dùng Concurrent libs