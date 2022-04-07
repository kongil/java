enum Transportation {
    // 각 열거형 상수가 이 추상 메서드를 반드시 구현해야 한다. 각 열겨형 상수별로 추상메서드 fare 다르게 구현 가능하다.
    BUS(100) { int fare(int distance) {return distance*BASIC_FARE;}},
    TRAIN(150) { int fare(int distance) {return distance*BASIC_FARE;}},
    SHIP(100) { int fare(int distance) {return distance*BASIC_FARE+100;}},
    AIRPLANE(300) { int fare(int distance) {return distance*BASIC_FARE;}};

    protected final int BASIC_FARE; // protected로 해야 각 상수에서 접근 가능, public도 가능, private이나 default로 하면 파생클래스가 접근 불가.

    Transportation(int basicFare) { //private Transportation(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() {
        return BASIC_FARE;
    }

    abstract int fare(int distance); // 거리에 따른 요금 계산
}
public class EnumEx3 {
    public static void main(String[] args) {

        System.out.println("bus fare=" + Transportation.BUS.fare(100));
        System.out.println("train fare=" + Transportation.TRAIN.fare(100));
        System.out.println("ship fare=" + Transportation.SHIP.fare(100));
        System.out.println("airplane fare=" + Transportation.AIRPLANE.fare(100));

    }
}
