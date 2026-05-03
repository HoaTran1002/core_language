package knowledge.memory_model;

public class MemoryVisibilityDemo {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            long iterations = 0;
            while (running) {
                iterations++;
            }
            System.out.println("Worker noticed stop after iterations=" + iterations);
        }, "memory-worker");

        worker.start();
        Thread.sleep(100);
        running = false;
        worker.join();
        System.out.println("Main thread finished.");
    }
}
