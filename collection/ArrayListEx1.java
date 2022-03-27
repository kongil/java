import java.util.*;

/*
    1. add
    2. subList
    3. Collections.sort
    4. containsAll
    4. set( ,)
    5. retainAll()
    6. contains
    7. removove
 */
public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add(new Integer(5));
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(3);

        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        print(list1, list2);

        list2.set(3, "AA");
        print(list1, list2);

        System.out.println("list1.retainAll(list2) = " + list1.retainAll(list2));
        print(list1, list2);

        for (int i = list2.size()-1; i >= 0; i--) {
        //for (int i = 0; i < list2.size(); i++) {  -> 이렇게 사용하면 안되는 이유 : 계속해서 list2가 삭제되므로 list.size()의 크기가 변동되기 떄문이다.
            System.out.println(i);
            if (list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }

        print(list1, list2);

    }

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }
}
