import java.util.*;

// 제한된 지네릭 클래스
class Fruit3 implements Eatable {
    @Override
    public String toString() {
        return "Fruit{}";
    }
}

class Apple3 extends Fruit3 {
    @Override
    public String toString() {
        return "Apple{}";
    }
}
class Grape3 extends Fruit3 {
    @Override
    public String toString() {
        return "Grape{}";
    }
}

class Juice {
    String name;

    public Juice(String name) {
        this.name = name + "Juice";
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit3> box) {
        String tmp = "";

        for (Fruit3 f : box.getList())
            tmp += f + " ";

        return new Juice(tmp);
    }
}
public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox<Fruit3> fruitBox = new FruitBox<Fruit3>();
        FruitBox<Apple3> appleBox = new FruitBox<Apple3>();

        fruitBox.add(new Apple3());
        fruitBox.add(new Grape3());
        appleBox.add(new Apple3());
        appleBox.add(new Apple3());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    }
}

class FruitBox<T extends Fruit3> extends Box3<T> {

}

class Box3<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {
        list.add((item));
    }
    T get(int i) {
        return list.get(i);
    }
    ArrayList<T> getList() { return list; }
    int size() { return list.size(); }

    @Override
    public String toString() {
        return list.toString();
    }
}
