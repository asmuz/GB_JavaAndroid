package HomeWork3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final char DOT_X = 'X';//символ крестика
    public static final char DOT_O = 'O';//символ нолика
    public static final char DOT_EMPTY = '•';//символ пустой ячейки
    public static final Scanner SCAN = new Scanner(System.in);//сканнер
    public static final Random RAND = new Random();//рандом для хода компьютера
    public static char[][] map;//массив игрового поля
    public static final int MAP_SIZE = 5;// размер поля
    public static final int WIN_SIZE = 4;// комбинация для выигрыша

    public static void main(String[] args) {
        initMap();
        while (true) {
            userTurn(); // ход игрока
            if (checkWin1(DOT_X)) {// проверяем выиграл ли игрок 1
                System.out.println("Игрок победил!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
            if (!blocking(DOT_X)) randomTurn();//если нужно, блокируем выигрышную кобинацию, или делаем рандомный ход

            if (checkWin1(DOT_O)) {// проверяем выиграл ли игрок 2
                System.out.println("Компьютер победил!");
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
        System.out.println();
    }

    public static void userTurn() { // ход игрока
        System.out.println("Ход игрока:\nВведите номер СТРОКИ и КОЛОНКИ:");
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
        System.out.println("Ход компьютера:");
        int row, col;
        do {
            row = RAND.nextInt(MAP_SIZE);
            col = RAND.nextInt(MAP_SIZE);
        } while (!cellValid(row, col));// проверяем, можно ли сюда ходить
        map[row][col] = DOT_O; //печатаем нолик в указанную ячейку
        printMap();//печатаем игровое поле
    }

    public static void turn(int row, int col, char dot) {
        map[row][col] = dot; //печатаем в указанную ячейку
    }

    public static boolean checkWin1(char ch) {

        /* Медод проверки заключается в подсчете количества определенных символов в строке, колонке или диагонали
         * метод довольно примитивен и не подходит для полей с размерностью болше 5, а так же проверка диагоналей
         * может не работать корректно на болях больше 3 */

        boolean flagX = false;//флаг "неразрывности" комбинации
        boolean flagY = false;
        boolean flagD1 = false;
        boolean flagD2 = false;
        for (int i = 0; i < MAP_SIZE; i++) {//запускаем внешний цикл для вертикали и горизонтали
            int countX = 0;//сбрасываем счетчик символов по горизонтали
            int countY = 0;//сбрасываем счетчик символов по вертикали
            int countD1 = 0;//сбрасываем счетчик символов по диагонали 1
            int countD2 = 0;//сбрасываем счетчик символов по диагонали 2
            for (int j = 0; j < MAP_SIZE; j++) {//запускаем внутренний цикл
                // проверки по горизонтали
                if (map[i][j] == ch && !flagX) {// если нужный символ первый в комбинации (флаг опущен)
                    countX = 1;//начинаем считать
                    flagX = true;//поднимаем флаг
                } else if (map[i][j] == ch && flagX) {//если нужный символ идёт в комбинации (флаг поднят)
                    countX++;//прибавляем счетчик
                } else if (map[i][j] != ch) {// если нужного символа нет
                    countX = 0;//сбрасываем счетчик
                    flagX = false; //опускаем флаг
                }
                // проверки по вертикали
                if (map[j][i] == ch && !flagY) {// если нужный символ первый в комбинации (флаг опущен)
                    countY = 1;//начинаем считать
                    flagY = true;//поднимаем флаг
                } else if (map[j][i] == ch && flagY) {//если нужный символ идёт в комбинации (флаг поднят)
                    countY++;//прибавляем счетчик
                } else if (map[j][i] != ch) {// если нужного символа нет
                    countY = 0;//сбрасываем счетчик
                    flagY = false; //опускаем флаг
                }
                // проверки по диагонали 1
                if (map[j][j] == ch && !flagD1) {// если нужный символ первый в комбинации (флаг опущен)
                    countD1 = 1;//начинаем считать
                    flagD1 = true;//поднимаем флаг
                } else if (map[j][j] == ch && flagD1) {//если нужный символ идёт в комбинации (флаг поднят)
                    countD1++;//прибавляем счетчик
                } else if (map[j][j] != ch) {// если нужного символа нет
                    countD1 = 0;//сбрасываем счетчик
                    flagD1 = false; //опускаем флаг
                }
                // проверки по диагонали 2
                if (map[MAP_SIZE - j - 1][j] == ch && !flagD2) {// если нужный символ первый в комбинации (флаг опущен)
                    countD2 = 1;//начинаем считать
                    flagD2 = true;//поднимаем флаг
                } else if (map[MAP_SIZE - j - 1][j] == ch && flagD2) {//если нужный символ идёт в комбинации (флаг поднят)
                    countD2++;//прибавляем счетчик
                } else if (map[MAP_SIZE - j - 1][j] != ch) {// если нужного символа нет
                    countD2 = 0;//сбрасываем счетчик
                    flagD2 = false; //опускаем флаг
                }
            }
            if (countX >= WIN_SIZE || countY >= WIN_SIZE || countD1 >= WIN_SIZE || countD2 >= WIN_SIZE)
                return true;//если в строке, колонке или диагоналях есть необходимое количество символов, значит победа
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean blocking(char ch) {
        // Если у игрока почти выигрышная комбинация, блокируем его ход

        for (int i = 0; i < MAP_SIZE; i++) { //запускаем внешний цикл
            int countX = 0;// сбрасываем счётчик заполненных клеток по горизонтали
            int emptyX = 0;// сбрасываем счётчик пустых клеток по горизонтали
            int countY = 0;// сбрасываем счётчик заполненных клеток по вертикали
            int emptyY = 0;// сбрасываем счётчик пустых клеток по вертикали
            int countD1 = 0;// сбрасываем счётчик заполненных клеток по диагонали 1
            int emptyD1 = 0;// сбрасываем счётчик пустых клеток по диагонали 1
            int countD2 = 0;// сбрасываем счётчик заполненных клеток по диагонали 2
            int emptyD2 = 0;// сбрасываем счётчик пустых клеток по диагонали 2
            for (int j = 0; j < MAP_SIZE; j++) { //запускаем внутренний цикл
                if (map[i][j] == DOT_EMPTY) emptyX++;
                if (map[i][j] == ch) countX++;
                if (map[j][i] == DOT_EMPTY) emptyY++;
                if (map[j][i] == ch) countY++;
                if (map[j][j] == DOT_EMPTY) emptyD1++;
                if (map[j][j] == ch) countD1++;
                if (map[MAP_SIZE - j - 1][j] == DOT_EMPTY) emptyD2++;
                if (map[MAP_SIZE - j - 1][j] == ch) countD2++;
            }
            if (countX == (WIN_SIZE - 1) && emptyX > 0) {//если в ряду почти выигрышная комбинация и есть пустая ячейка
                for (int k = 0; k < MAP_SIZE; k++) {// пробегаем по этому ряду
                    if (cellValid(i, k)) {
                        map[i][k] = DOT_O;// и блокируем свободную клетку
                    }
                }
                printMap();// печатаем поле
                return true;// передаём, что ход заблокирован
            }
            if (countY == (WIN_SIZE - 1) && emptyY > 0) {//если в колонке почти выигрышная комбинация и есть пустая ячейка
                for (int k = 0; k < MAP_SIZE; k++) {// пробегаем по этой колонке
                    if (cellValid(k, i)) {
                        map[k][i] = DOT_O;// и блокируем свободную клетку
                    }
                }
                printMap();// печатаем поле
                return true;// передаём, что ход заблокирован
            }
            if (countD1 == (WIN_SIZE - 1) && emptyD1 > 0) {//если по диагонали 1 почти выигрышная комбинация и есть пустая ячейка
                for (int k = 0; k < MAP_SIZE; k++) {// пробегаем по этой диагонали
                    if (cellValid(k, k)) {
                        map[k][k] = DOT_O;// и блокируем свободную клетку
                    }
                }
                printMap();// печатаем поле
                return true;// передаём, что ход заблокирован
            }
            if (countD2 == (WIN_SIZE - 1) && emptyD2 > 0) {//если по диагонали 1 почти выигрышная комбинация и есть пустая ячейка
                for (int k = 0; k < MAP_SIZE; k++) {// пробегаем по этой диагонали
                    if (cellValid(MAP_SIZE - k - 1, k)) {
                        map[MAP_SIZE - k - 1][k] = DOT_O;// и блокируем свободную клетку
                    }
                }
                printMap();// печатаем поле
                return true;// передаём, что ход заблокирован
            }

        }
        return false;
    }
}
