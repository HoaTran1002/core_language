package technical.garbage_collection;

import java.util.ArrayList;
import java.util.List;

public class MemoryPressureDemo {
    public static void main(String[] args) {
        List<byte[]> allocations = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            allocations.add(new byte[1024 * 1024]);
            long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("step=" + i + " used_mb=" + usedBytes / (1024 * 1024));
        }

        allocations.clear();
        System.gc();
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("after_gc_used_mb=" + usedBytes / (1024 * 1024));
    }
}
