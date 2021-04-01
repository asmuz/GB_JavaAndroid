package HomeWork7;

public class Human implements Runner {
    private String name;
    private String type;
    private int maxRun;
    private int maxJump;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.type = "Человек";
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

}