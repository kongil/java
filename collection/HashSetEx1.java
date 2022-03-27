import java.util.*;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] objArr = {"1", 1, "2", "2", "3", "3", "3", "4", "4", "4"};
        Set set = new HashSet();

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);
        }

        System.out.println(set); // 문자열 1, 정수형 1 각각들어감
    }
}
