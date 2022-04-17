import java.util.*;
import java.util.stream.*;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("니자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan) // 반별 정렬
                .thenComparing(Comparator.naturalOrder()))         // 기본 정렬
                .forEach(System.out::println);

    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return String.format ("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}