package HomeWork5;

public class Cat extends Animal {
    static int counter;

    public Cat(String name) {
        super(name);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void run(int len) {
        if (len <= 200) System.out.println("Кот " + name + " пробежал " + len + " м.");
        else System.out.println("Кот " + name + " не может пробежать " + len + " м.");
    }

    @Override
    public void swim(int len) {
        System.out.println("Коты не любят плавать");
    }
}
