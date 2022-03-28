import java.util.*;

public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id p/w 입력");
            System.out.println("id : ");
            String id = sc.nextLine().trim();

            System.out.println("p/w : ");
            String pw = sc.nextLine().trim();
            System.out.println();

            if (!map.containsKey(id)) {
                System.out.println("입력학신 id가 존재하지 않습니다." + "다시 입려갷주세요.");
                continue;
            }

            if (!map.get(id).equals(pw)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            }
            else {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }

        }
    }
}
