package HomeWork7;

public interface Runner {
    String getName();

    String getType();

    int getMaxRun();

    int getMaxJump();

    default boolean run(int length) {
        if (length <= getMaxRun()) {
            System.out.printf("%s %s пробежал %d метров по треку\n", getType(), getName(), length);
            return true;
        } else {
            System.out.printf("%s %s сходит с дистанции, т.к. не может пробежать %d метров по треку. Его предел всего %s метров! \n", getType(), getName(), length, getMaxRun());
            return false;
        }
    }

    default boolean jump(int height) {
        if (height <= getMaxRun()) {
            System.out.printf("%s %s перепрыгнул через препятствие высотой %d сантиметров\n", getType(), getName(), height);
            return true;
        } else {
            System.out.printf("%s %s сходит с дистанции, т.к. не может перепрыгнуть препятствие высотой %d сантиметров. Его предел всего %s сантиметров! \n", getType(), getName(), height, getMaxJump());
            return false;
        }
    }

    default boolean start(Equipment equipment){
        if(equipment instanceof Track) return run(equipment.getSize());// если это трек, БЕЖИМ
        else return jump(equipment.getSize()); // иначе ПРЫГАЕМ
    };
}
