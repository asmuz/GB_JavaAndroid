package HomeWork7;

public class Track implements Equipment{
    private int size;

    public Track(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
