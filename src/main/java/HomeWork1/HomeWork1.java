package HomeWork1;

public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println(methodOne(2, 3, 4, 5));
        System.out.println(methodTwo(9, 7));
        methodThree(77);
        methodThree(-7);
        methodFour("Василий");
        methodFive(2020);
        methodFive(2021);
    }

    /* 1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
    где a, b, c, d – целочисленные входные параметры этого метода;*/
    public static double methodOne(int a, int b, int c, int d) {
        return a * (b + (c / (d * 1.0)));
    }

    /* 2. Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false;*/
    public static boolean methodTwo(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /* 3. Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число передали, или отрицательное.
    Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль*/
    public static void methodThree(int a) {
        if (a >= 0) System.out.println("Число " + a + " положительное");
        else System.out.println("Число " + a + " отрицательное");
    }

    /* 4. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.*/
    public static void methodFour(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /* 5*. Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го,
        при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль*/
    public static void methodFive(int year) {
        if (((year % 4 == 0) || (year % 400 == 0)) && (year % 100 != 0))
            System.out.println("Год " + year + " високосный");
        else System.out.println("Год " + year + " не високосный");
    }
}
