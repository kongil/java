import java.util.*;

class Fruit {
    @Override
    public String toString() {
        return "Fruit{}";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple{}";
    }
}
class Grape extends Fruit {
    @Override
    public String toString() {
        return "Grape{}";
    }
}
class Toy{
    @Override
    public String toString() {
        return "Toy{}";
    }
}
public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox = new Box<Toy>();
        //Box<Grape> grapeBox = new Box<Apple>(); // 에러, 타입 불일치

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); // OK. void add(Fruit item) 생성과 달리 자손이 들어갈 수 있다.

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        //appleBox.add(new Toy()); // 에러, Box<Apple>에는 Apple만 담을 수 있음

        toyBox.add(new Toy());
        //toyBox.add(new Apple()); // 에러

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    }

}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {
        list.add((item));
    }
    T get(int i) {
        return list.get(i);
    }
    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}