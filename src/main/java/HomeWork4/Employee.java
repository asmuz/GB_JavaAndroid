package HomeWork4;

// создаем класс "Сотрудник"
public class Employee {
    // инициируем необходимые поля
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    // создаем конструктор
    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // создаем геттер для возраста
    public int getAge() {
        return age;
    }

    // метод печати информации о сотруднике
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("E-Mail: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println("- - - - - - - - - -");
    }

}
