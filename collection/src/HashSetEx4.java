import java.util.HashSet;
import java.util.Objects;

// set에서 add메서드에서 class를 비교하기 위해서는 equals()와 hashCode()를 오버라이딩해야한다.
public class HashSetEx4 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);
    }
}

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person2) {
            Person2 tmp = (Person2) obj;
            return age == tmp.age && name.equals(tmp.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
        //return (name + age).hashCode();
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}
