package knowledge.syntax_basics;

public class SyntaxBasicsDemo {
    private static final String LANGUAGE = "Java";

    public static void main(String[] args) {
        int version = 21;
        boolean stable = true;
        String summary = LANGUAGE + " " + version + " stable=" + stable;

        System.out.println(summary);
        greet("core_language");
    }

    private static void greet(String project) {
        System.out.println("Hello from " + project + " using basic Java syntax.");
    }
}
