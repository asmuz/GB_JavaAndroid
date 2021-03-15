package HomeWork5;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int len) {
        System.out.println(name + " пробежал " + len + " метров");
    }

    public void swim(int len) {
        System.out.println(name + " проплыл " + len + " метров");
    }
}
