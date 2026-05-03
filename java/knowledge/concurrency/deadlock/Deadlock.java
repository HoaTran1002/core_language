package knowledge.concurrency.deadlock;

// Demonstrates a classic deadlock scenario with nested synchronized calls.
public class Deadlock {
    static class Friend {
        private final String name;

        Friend(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        synchronized void bow(Friend other) {
            System.out.format("%s: %s has bowed to me!%n", name, other.getName());
            other.bowBack(this);
        }

        synchronized void bowBack(Friend other) {
            System.out.format("%s: %s has bowed back to me!%n", name, other.getName());
        }
    }

    public static void main(String[] args) {
        Friend alphonse = new Friend("Alphonse");
        Friend gaston = new Friend("Gaston");

        new Thread(() -> alphonse.bow(gaston), "thread-alphonse").start();
        new Thread(() -> gaston.bow(alphonse), "thread-gaston").start();
    }
}
