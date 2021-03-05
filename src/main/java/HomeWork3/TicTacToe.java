package HomeWork3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final char DOT_X = 'X';//символ крестика
    public static final char DOT_O = 'O';//символ нолика
    public static final char DOT_EMPTY = '•';//символ пустой ячейки
    public static final Scanner SCAN = new Scanner(System.in);//сканнер
    public static final Random RAND = new Random();//рандом для ходя компьютера
    public static char[][] map;//массив игрового поля
    public static final int MAP_SIZE = 3;// размер поля
    public static final int WIN_SIZE = 3;// комбинация для выигрыша

    public static void main(String[] args) {
        initMap();
        while(true) {
            userTurn();
            if (checkWin1(DOT_X)) {
                System.out.println("Игрок победил!");//проверяем выиграл ли игрок
                break;
            }
            randomTurn();
            if (checkWin1(DOT_O)) {
                System.out.println("Компьютер победил!");//проверяем выиграл ли игрок
                break;
            }
        }
    }

    public static void initMap() { // создание нового игрового поля
        map = new char[MAP_SIZE][MAP_SIZE];// создаем квадратный массив
        for (int row = 0; row < MAP_SIZE; row++) {
            for (int col = 0; col < MAP_SIZE; col++) {
                map[row][col] = DOT_EMPTY;// заполняем пустыми символами
            }
        }
        printMap();//печатаем игровое поле
    }

    public static void printMap() { // печать игрового поля в консоль
        System.out.print("  ");
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int y = 0; y < MAP_SIZE; y++) {
            System.out.print(y + 1 + " ");
            for (int x = 0; x < MAP_SIZE; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
    }

    public static void userTurn() { // ход игрока
        int row, col;
        do {
            row = SCAN.nextInt() - 1;// ожидаем ввод координат
            col = SCAN.nextInt() - 1;// ожидаем ввод координат
        } while (!cellValid(row, col));// проверяем, можно ли сюда ходить
        map[row][col] = DOT_X; //печатаем крестик в указанную ячейку
        printMap();//печатаем поле
    }

    public static boolean cellValid(int row, int col) { // проверка ячейки на валидность
        if (row < 0 || row > MAP_SIZE - 1 && col < 0 || col > MAP_SIZE - 1) return false; // если вышли за пределы поля
        if (map[row][col] == DOT_EMPTY) return true;// если ячейка пустая, то все ОК
        return false; // если поле занято
    }

    public static void randomTurn() { //ход компьютера "на угад"
        int row, col;
        do {
            row = RAND.nextInt(MAP_SIZE);
            col = RAND.nextInt(MAP_SIZE);
        } while (!cellValid(row, col));// проверяем, можно ли сюда ходить
        map[row][col] = DOT_O; //печатаем нолик в указанную ячейку
        System.out.println();//пустая строка перед выводом поля
        printMap();//печатаем игровое поле
    }

    public static boolean checkWin1(char ch){
        /* Медод проверки заключается в подсчете количества определенных символов в строке, колонке или диагонали
        * метод довольно примитивен и не подходит для полей с размерностью болше 5, а так же проверка диагоналей
        * может не работать корректно на болях больше 3 */
        for (int i = 0; i < MAP_SIZE; i++) {//запускаем внешний цикл
            int countX = 0;//сбрасываем счетчик символов по горизонтали
            int countY = 0;//сбрасываем счетчик символов по вертикали
            int countD1 = 0;//сбрасываем счетчик символов по диагонали 1
            int countD2 = 0;//сбрасываем счетчик символов по диагонали 2
            for (int j = 0; j < MAP_SIZE; j++) {//запускаем внутренний цикл
                if(map[i][j] == ch) countX++;//считаем сколько символов в строке
                if(map[j][i] == ch) countY++;//считаем сколько символов в колонке
                if(map[j][j] == ch) countD1++;//считаем сколько символов в диагонали 1
                if(map[MAP_SIZE - 1 - j][j] == ch) countD2++;//считаем сколько символов в диагонали 2
            }
            if (countX == WIN_SIZE || countY == WIN_SIZE || countD1 == WIN_SIZE || countD2 == WIN_SIZE) return true;

        }
        return false;
    }
}
