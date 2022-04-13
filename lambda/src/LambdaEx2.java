@FunctionalInterface
interface MyFunction2 {
    void myMethod(); // public abstract void myMethod();
}

public class LamdaEx2 {
    public static void main(String[] args) {
        MyFunction2 f = () -> {}; // MyFUntion f = (MyFunction)(()->{}));
        Object obj = (MyFunction2)(() -> {}); // Object타입으로 형변환이 생략됨
        String str = ((Object)(MyFunction2)(() -> {})).toString(); // 굳이 Object 타입으로 변경하려면, 먼저 함수형 인터페이스로 변환해야한다.

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        //System.out.println(()->{}); // 에러. 람다식은 Object 타입으로 형변환 안됨
        System.out.println((MyFunction2)(()->{}));
        //System.out.println((MyFunction2)(()->{})).toString()); // 에러
        System.out.println(((Object)(MyFunction2)(() -> {})).toString());
    }
}
