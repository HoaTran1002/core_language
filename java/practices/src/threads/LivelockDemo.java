package practices.src.threads;

class Spoon {
    private Diner owner;
    public Spoon(Diner d) { owner = d; }
    public Diner getOwner() { return owner; }
    public void setOwner(Diner d) { owner = d; }
}

class Diner {
    private String name;
    private boolean isHungry = true;

    public Diner(String name) {
        this.name = name;
    }

    public void eatWith(Spoon spoon, Diner partner) {
        while (isHungry) {
            if (spoon.getOwner() != this) {
                // Nhường muỗng
                continue;
            }
            if (partner.isHungry) {
                // Nhường muỗng nếu đối phương còn đói
                spoon.setOwner(partner);
                System.out.println(name + ": bạn ăn trước đi...");
                continue;
            }
            System.out.println(name + " ăn xong!");
            isHungry = false;
        }
    }
}
// Nhường lẫn nhau
public class LivelockDemo {
    public static void main(String[] args) {
        Diner a = new Diner("Alphonse");
        Diner b = new Diner("Gaston");
        Spoon spoon = new Spoon(a);

        new Thread(() -> a.eatWith(spoon, b)).start();
        new Thread(() -> b.eatWith(spoon, a)).start();
    }
}
// ⭐ Tránh Livelock:

// Không nhường tài nguyên quá “lịch sự”

// Dùng random back-off

// Dùng timeout/counter