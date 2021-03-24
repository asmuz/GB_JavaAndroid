package HomeWork6;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public void putFood(int amount) {
        this.food += amount;
    }

    public void decreaseFood(int amount) {
        this.food -= amount;
    }

    public void increaseFood(int amount) {
        this.food += amount;
        System.out.println("В миску положили " + amount + " еды");
    }

    public int getFood() {
        return this.food;
    }
}
