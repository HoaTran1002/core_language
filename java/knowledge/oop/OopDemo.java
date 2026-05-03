package knowledge.oop;

interface Greeter {
    String greet();
}

class Person implements Greeter {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String greet() {
        return "Hello, I am " + name;
    }
}

class Student extends Person {
    private final String track;

    Student(String name, String track) {
        super(name);
        this.track = track;
    }

    @Override
    public String greet() {
        return super.greet() + " and I study " + track;
    }
}

public class OopDemo {
    public static void main(String[] args) {
        Greeter greeter = new Student("Hoa", "backend engineering");
        System.out.println(greeter.greet());
    }
}
