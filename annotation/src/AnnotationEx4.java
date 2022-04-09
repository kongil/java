import java.util.*;

class MyArrayList<T> {
    T[] arr;

    @SafeVarargs
    @SuppressWarnings("varargs") // -Xlint옵션을 붙여서 컴파일 했을때는 varargs 경고가 발생하는 것을 막아줌
    MyArrayList(T... arr) {
        this.arr = arr;
    }

    @SafeVarargs
    public static <T> MyArrayList<T> asLIst(T... a) {
        return new MyArrayList<>(a);
    }

    public String toString() {
        return Arrays.toString(arr);
    }
}

public class AnnotationEx4 {
    public static void main(String[] args) {
        MyArrayList<String> list = MyArrayList.asLIst("1", "2", "3");

        System.out.println(list);
    }
}
