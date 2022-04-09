import java.util.*;

// @Deprecated : 다른 것으로 대체되어 더 이상 사용되지 않을 것을 권함 -> intelliJ 에서도 선을 그음 (강제성은 없음)
class NewClass {
    int newField;

    int getNewField() { return newField; }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() { return oldField; }
}

public class AnnotationEx2 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;
        System.out.println(nc.getOldField());
    }
}
