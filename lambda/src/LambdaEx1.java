@FunctionalInterface
interface MyFuction {
    void run(); // public abstract void run();
}

public class LambdaEx1 {
    static void execute(MyFuction f) { // 매개변수의 타입이 MyFunction인 메서드
        f.run();
    }

    static MyFuction getMyFunction() {
        MyFuction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction의 run()을 구현
        MyFuction f1 = () -> System.out.println("f1.run()");

        // 익명클래스로 run()을 구현
        MyFuction f2 = new MyFuction() {
            public void run() { // public을 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };

        MyFuction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute( () -> System.out.println("run()") );
    }
}
