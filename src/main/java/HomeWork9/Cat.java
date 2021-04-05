package HomeWork9;

public class Cat {
    private int id;
    private String name;
    private String color;
    private int age;
    private String info;

    public Cat(int id, String name, String color, int age, String info) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}