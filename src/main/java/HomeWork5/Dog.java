package HomeWork5;

public class Dog extends Animal {
    static int counter;

    public Dog(String name) {
        super(name);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void run(int len) {
        if (len <= 500) System.out.println("Пёс " + name + " пробежал " + len + " м.");
        else System.out.println("Пёс " + name + " не может пробежать " + len + " м.");
    }

    @Override
    public void swim(int len) {
        if (len <= 10) System.out.println("Пёс " + name + " проплыл " + len + " м.");
        else System.out.println("Пёс " + name + " не может проплыть " + len + " м.");
    }
}
