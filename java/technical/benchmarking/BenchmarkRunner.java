package technical.benchmarking;

public class BenchmarkRunner {
    private static final String[] BENCHMARK_CLASSES = {
        "technical.benchmarking.CpuBoundTests",
        "technical.benchmarking.MemoryBoundTests",
        "technical.benchmarking.IoBoundTests",
        "technical.benchmarking.ConcurrencyTests",
        "technical.benchmarking.ThroughputTests"
    };


    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();

        System.out.println("Starting benchmarks...");
        for (String className : BENCHMARK_CLASSES) {
            runIfPresent(className);
        }

        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start) / 1_000_000 + " ms");
    }

    private static void runIfPresent(String className) throws Exception {
        try {
            Class<?> benchmarkClass = Class.forName(className);
            benchmarkClass.getMethod("run").invoke(null);
        } catch (ClassNotFoundException e) {
            System.out.println("Skip missing benchmark: " + className);
        }
    }
}
