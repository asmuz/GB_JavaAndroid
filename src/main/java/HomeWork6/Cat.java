package HomeWork6;

public class Cat {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Bowl bowl) {
        bowl.decreaseFood(this.appetite);
        System.out.printf("Cat %s had ate from bowl for %d food!\n", this.name, this.appetite);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }
}
