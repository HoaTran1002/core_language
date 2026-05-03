package knowledge.concurrency.livelock;

class Spoon {
    private Diner owner;

    public Spoon(Diner d) {
        owner = d;
    }

    public Diner getOwner() {
        return owner;
    }

    public void setOwner(Diner d) {
        owner = d;
    }
}

class Diner {
    private final String name;
    private boolean isHungry = true;

    public Diner(String name) {
        this.name = name;
    }

    public void eatWith(Spoon spoon, Diner partner) {
        while (isHungry) {
            if (spoon.getOwner() != this) {
                continue;
            }
            if (partner.isHungry) {
                spoon.setOwner(partner);
                System.out.println(name + ": ban an truoc di...");
                continue;
            }
            System.out.println(name + " an xong!");
            isHungry = false;
        }
    }
}

// Demonstrates livelock where both threads keep yielding to each other.
public class LivelockDemo {
    public static void main(String[] args) {
        Diner a = new Diner("Alphonse");
        Diner b = new Diner("Gaston");
        Spoon spoon = new Spoon(a);

        new Thread(() -> a.eatWith(spoon, b)).start();
        new Thread(() -> b.eatWith(spoon, a)).start();
    }
}
