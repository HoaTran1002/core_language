package technical.jvm_performance;

public class JitWarmupDemo {
    private static long squareSum(int limit) {
        long total = 0;
        for (int i = 0; i < limit; i++) {
            total += (long) i * i;
        }
        return total;
    }

    public static void main(String[] args) {
        for (int round = 1; round <= 5; round++) {
            long start = System.nanoTime();
            long result = squareSum(2_000_000);
            long elapsedMicros = (System.nanoTime() - start) / 1_000;
            System.out.println("round=" + round + " result=" + result + " elapsed_us=" + elapsedMicros);
        }
    }
}
