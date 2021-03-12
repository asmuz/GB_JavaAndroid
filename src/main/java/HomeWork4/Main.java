package HomeWork4;

/*  1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 *  Конструктор класса должен заполнять эти поля при создании объекта.
 *  Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 *  2. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 * */

public class Main {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5]; // инициируем массив сотрудников и заполняем его
        employeeArray[0] = new Employee("Vasily", "Director", "vasily@mail.ru", "+7-111-111-1111", 100_000, 44);
        employeeArray[1] = new Employee("Peter", "Programmer", "peter@mail.ru", "+7-222-222-2222", 70_000, 31);
        employeeArray[2] = new Employee("Maria", "Accountant", "maria@mail.ru", "+7-333-333-3333", 80_000, 50);
        employeeArray[3] = new Employee("Sergey", "Driver", "sergey@mail.ru", "+7-444-444-4444", 50_000, 28);
        employeeArray[4] = new Employee("Svetlana", "Cleaning", "svetlana@mail.ru", "+7-555-555-5555", 40_000, 55);

        for (int i = 0; i < employeeArray.length; i++) {
            // проверяем возраст и выводим информацию о сотрудниках старше 40 лет
            if(employeeArray[i].getAge() > 40) employeeArray[i].printInfo();
        }
    }
}
