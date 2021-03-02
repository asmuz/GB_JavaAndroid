package HomeWork2;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        int[] arr1 = randomArray(10, 2); // генерируем массив
        printArray(arr1); // выводим массив в консоль
        printArray(taskOne(arr1)); // запускаем метод и выводим результат

        System.out.println("\nЗадание 2:");
        printArray(taskTwo(8, 3));

        System.out.println("\nЗадание 3:");
        int[] arr3 = randomArray(10, 12); // генерируем массив
        printArray(arr3); // выводим массив в консоль
        printArray(taskThree(arr3)); // запускаем метод и выводим результат

        System.out.println("\nЗадание 4:");
        taskFour(7); // запускаем метод и выводим результат

        System.out.println("Задание 5:");
        taskFive(10, 100);

        System.out.println("\nЗадание 6:");
        int[] arr6 = randomArray(10, 3); // генерируем массив
        printArray(arr6); // выводим массив в консоль
        System.out.println(taskSix(arr6)); // запускаем метод и выводим результат

        System.out.println("\nЗадание 7:");
        int[] arr7 = randomArray(10, 9); // генерируем массив
        printArray(arr7); // выводим массив в консоль
        printArray(taskSeven(arr7, 3)); // сдвигаем элементы в массиве на n ячеек влево или вправо в зависимости от знака
        printArray(taskSeven(arr7, -2)); // сдвигаем элементы в массиве на n ячеек влево или вправо в зависимости от знака
    }

    public static int[] taskOne(int[] arr) {
    /*  1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0; */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0; // проверяем и преобразуем
            else arr[i] = 1;
        }
        return arr; // возвращаем преобразованный массив
    }

    public static int[] taskTwo(int len, int step) {
    /*  2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21; */
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i * step; // заполняем массив прогрессией c шагом step
        }
        return arr; // возвращаем преобразованный массив
    }

    public static int[] taskThree(int[] arr) {
    /*  3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2; */
        //int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2; // проверяем и преобразуем нужные элементы массива
        }
        return arr; // возвращаем преобразованный массив
    }

    public static void taskFour(int size) {
    /*  4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами; */
        int[][] arr = new int[size][size]; // создаём квадратный массив произвольного размемра
        print2dArray(arr); // выводим в консоль пустой массив
        for (int i = 0; i < arr.length; i++) { // используем 1 цикл, т.к массив "квадратный"
            arr[i][i] = 1; //заполняем первую диагональ
            arr[arr.length - i - 1][i] = 1; // заполняем вторую диагональ
        }
        print2dArray(arr); // выводим в консоль результат
    }

    public static void taskFive(int arraySize, int arrayMax) {
    /*  5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);*/
        int[] arr = randomArray(arraySize, arrayMax);// сгенерируем случайный массив
        int min = arrayMax; // переменная для хранения минимального
        int max = 0; // и максимального значения
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i]; // если текущий элемент меньше минимального, то минимальный этот элемент
            if (arr[i] > max) max = arr[i]; // аналогично с максимальным
        }
        System.out.println("Array: " + Arrays.toString(arr));  // выводим массив
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    public static boolean taskSix(int[] arr) {
    /*  6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят. */
        for (int i = 0; i < arr.length; i++) { // запускаем основной цикл
            int leftSum = 0; // сбрасываем сумму левой
            int rightSum = 0; // и правой части
            for (int j = 0; j <= i; j++) { // запускаем цикл для левой части
                leftSum = leftSum + arr[j]; // складываем все элементы левой части
            }
            for (int k = i + 1; k < arr.length; k++) { // запускаем цикл для правой части
                rightSum = rightSum + arr[k]; // складываем все элементы правой части
            }
            if (leftSum == rightSum) { // если суммы равны
                int[] leftArray = Arrays.copyOfRange(arr, 0, i + 1); // создаем копию левой части
                int[] rightArray = Arrays.copyOfRange(arr, i + 1, arr.length); // создаем копию правой части
                System.out.println(Arrays.toString(leftArray) + " == " + Arrays.toString(rightArray)); // наглядно показываем результат работы
                return true; // и возвращаем TRUE;
            }
        }
        return false;
    }

    public static int[] taskSeven(int[] arr, int n) {
    /*  7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
        Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ]
        при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        При каком n в какую сторону сдвиг можете выбирать сами. */

        if (n > 0) {// положительное значение определяет направление сдвига
            System.out.println("Циклично сдвигаем массив ВПРАВО на " + n);
            for (int i = 0; i < n; i++) {
                int last = arr[arr.length - 1];// запоминаем значение последнего элемента
                for (int j = arr.length - 1; j > 0; j--) {// проходим по массиву от последнего до второго элемента
                    arr[j] = arr[j - 1]; // и присваиваем текущему элементу значание перед ним
                }
                arr[0] = last; // первому элементу присваиваем значение последнего элемента
            }// повторяем необходимое количество раз
        }
        if (n < 0) {// отрицательное значение определяет направление сдвига
            n = Math.abs(n); // отбрасываем "минус" и получаем значение сдвига
            System.out.println("Циклично сдвигаем массив ВЛЕВО на " + n);
            for (int i = 0; i < n; i++) {
                int first = arr[0];// запоминаем значение первого элемента
                for (int j = 0; j < arr.length - 1; j++) {// проходим по массиву до предпоследнего элемента
                    arr[j] = arr[j + 1]; // и присваиваем текущему элементу значание следующего за ним
                }
                arr[arr.length - 1] = first; // последнему элементу присваиваем значение первого элемента
            }// повторяем необходимое количество раз
        }
        return arr; // возвращаем преобразованный массив
    }

    public static int[] randomArray(int size, int max) {
    /* Метод генерации одномерного массива */
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr; // возвращаем сгенерированнывй массив
    }

    public static void printArray(int[] arr) {
    /*  Печать в консоль одномерного массива; */
        System.out.println(Arrays.toString(arr));
    }

    public static void print2dArray(int[][] arr) {
    /*  Печать в консоль двумерного массива; */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();// перенос строки
        }
        System.out.println(); // пустая строка для красоты
    }

}
