package HomeWork8;

/*
1.  Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2.  Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
    массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
    исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

3.  В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
    и вывести результат расчета.
*/

public class Main {
    public static void main(String[] args) {
        String[][] array1 = new String[][]{   // Массив большего размера
                {"1", "2", "3", "4"},
                {"10", "20", "30", "40"},
                {"111", "222", "333", "444"},
                {"-100", "-200", "-300", "-400"},
                {"aaa", "bbb", "ccc", "!@#"}
        };
        String[][] array2 = new String[][]{ // Массив с символами
                {"1", "2", "3", "4"},
                {"10", "20", "30", "40"},
                {"-100", "-200", "-300", "-400"},
                {"aaa", "bbb", "ccc", "!@#"}
        };
        String[][] array3 = new String[][]{   // "Нормальный" массив
                {"1", "2", "3", "4"},
                {"10", "20", "30", "40"},
                {"111", "222", "333", "444"},
                {"-100", "-200", "-300", "-400"}
        };

        try {
            System.out.println("Сумма всех элементов массива: " + arraySum(array1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Сумма всех элементов массива: " + arraySum(array2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Сумма всех элементов массива: " + arraySum(array3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int arraySum(String[][] arr) {
        int sum = 0;
        if (arr.length != 4) throw new MyArraySizeException("Массив не подходящего размера! Нужен массив размера 4х4");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new MyArraySizeException("Массив не подходящего размера! Нужен массив размера 4х4");
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int current = Integer.parseInt(arr[i][j]);
                    sum = sum + current;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В ячейке [%d][%d] находится НЕ ЧИСЛО!", i, j));
                }
            }
        }
        return sum;
    }
}