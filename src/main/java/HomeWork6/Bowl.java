package HomeWork6;

public class Bowl {
    private int food;

    public void putFood(int amount) {
        this.food += amount;
    }

    public void decreaseFood(int amount) {
        this.food -= amount;
    }

    public int getFood() {
        return this.food;
    }
}
