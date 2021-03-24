package HomeWork6;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety; // сытость котика

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;// котик голоден
    }

    public void eat(Bowl bowl) {
        if (bowl.getFood() >= this.appetite) {
            bowl.decreaseFood(this.appetite);
            System.out.printf("Кот %s съел из миски %d еды\nВ миске осталось %d еды\n", this.name, this.appetite, bowl.getFood());
            this.satiety = true;// теперь котик сыт
        }
        else System.out.printf("В миске не хватает %s еды, чтобы кот %s наелся!\n", this.appetite - bowl.getFood(), this.name);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        if (satiety) System.out.printf("Кот %s сыт\n", this.name);
        else System.out.printf("Кот %s голоден\n", this.name);
        return satiety;
    }
}
