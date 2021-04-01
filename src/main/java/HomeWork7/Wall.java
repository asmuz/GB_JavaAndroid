package HomeWork7;

public class Wall implements Equipment{
    private int size;

    public Wall(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
