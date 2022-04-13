@FunctionalInterface
interface MyFunction3 {
    void myMethod();
}

class Outer {
    int val = 20; // Outer.this.val;

    class Inner {
        int val = 10; // this.val

        void method(final int i) { // void method(final int i) {
            int val = 30; // final int val=30;
            //i = 10;       // 에러. 상수의 값을 변경할 수 없음.

            MyFunction3 f = () -> {
                System.out.println("                 i :" + i); // final <- 참조하는 지역변수, 상수로 간주
                System.out.println("               val :" + val); // final <- 참조하는 지역변수, 상수로 간주
                System.out.println("          this.val :" + ++this.val); // 상수로 간주하지 않음. 참조 아니라 생각
                System.out.println("    Outer.this.val :" + ++Outer.this.val); // 상수로 간주하지 않음. 참조 아니라 생각
            };

            f.myMethod();
        }
    } // Inner클래스의 끝
} // Outer클래스의 끝

public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }

}
