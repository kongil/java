import java.util.*;

class NewClass3 {
    int newField;

    public int getNewField() {
        return newField;
    }

    @Deprecated
    int oldField;

    @Deprecated
    public int getOldField() {
        return oldField;
    }
}

public class AnnotationEx3 {
    @SuppressWarnings("deprecation") // deprecation 관련 경고를 억제
    public static void main(String[] args) {
        NewClass3 nc = new NewClass3();

        nc.oldField = 10;
        System.out.println("nc.getOldField() = " + nc.getOldField());

        @SuppressWarnings("unchecked")  // 지네릭스 관련 경고를 억제
        ArrayList<NewClass3> list = new ArrayList(); // 타입을 지정하지 않음
        list.add(nc);
    }
}
