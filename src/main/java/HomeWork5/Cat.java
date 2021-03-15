package HomeWork5;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
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
