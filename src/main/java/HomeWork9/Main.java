package HomeWork9;

/*
1.  Создать класс кота, с полями имя, цвет, что-нибудь еще.
2.  Создать в базе таблицу с котами.
3.  * Сделть класс для работы с котами в бд: запись кота в БД, чтение кота из базы, изменение...
 */

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat(1, "Барсик", "белый", 3, "Любит играть с клубком"),
                new Cat(2, "Мурзик", "серый", 5, "Любит спать на коврике"),
                new Cat(3, "Рыжик", "рыжий", 7, "Альфа самец")
        };

        try {
            DataBase.connect();
            for (int i = 0; i < cats.length; i++) {//добавляем котов из массива в базу данных
                DataBase.addCat(cats[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBase.disconnect();
        }
    }
}
