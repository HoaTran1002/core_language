package technical.testing_quality;

public class SimpleAssertionsDemo {
    private static int add(int left, int right) {
        return left + right;
    }

    public static void main(String[] args) {
        assert add(2, 3) == 5 : "2 + 3 should equal 5";
        assert add(-1, 1) == 0 : "-1 + 1 should equal 0";
        System.out.println("Assertions passed. Run with -ea to enforce checks.");
    }
}
