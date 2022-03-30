import java.util.ArrayList;

// 제한된 지네릭 클래스
class Fruit2 implements Eatable {
    @Override
    public String toString() {
        return "Fruit{}";
    }
}

class Apple2 extends Fruit2 {
    @Override
    public String toString() {
        return "Apple{}";
    }
}
class Grape2 extends Fruit2 {
    @Override
    public String toString() {
        return "Grape{}";
    }
}

class Toy2 {
    @Override
    public String toString() {
        return "Toy{}";
    }
}

interface Eatable {

}

public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox2 = new FruitBox2<Fruit2>();
        FruitBox2<Apple2> appleBox2 = new FruitBox2<Apple2>();
        FruitBox2<Grape2> grapeBox2 = new FruitBox2<Grape2>();
        // FruitBox2<Toy2> toyFruitBox2 = new FruitBox2<Toy2>(); // 에러 Fruit2상속 x, Eatable 구현 x
        //FruitBox2<Grape2> grapeFruitBox2 = new FruitBox2<Apple2>(); // 에러, 타입 불일치

        fruitBox2.add(new Fruit2());
        fruitBox2.add(new Apple2());
        fruitBox2.add(new Grape2());
        //fruitFruitBox2.add(new Apple2()); // OK. void add(Fruit2 item) 생성과 달리 자손이 들어갈 수 있다.

        appleBox2.add(new Apple2());
        //appleBox2.add(new Grape2()); // 에러, Grape는 Apple의 자손이 아님

        grapeBox2.add(new Grape2());


        System.out.println(fruitBox2);
        System.out.println(appleBox2);
        System.out.println(grapeBox2);
    }

}

class FruitBox2<T extends Fruit2 & Eatable> extends Box2<T> {

}

class Box2<T> {
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