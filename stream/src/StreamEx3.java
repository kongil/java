import java.util.*;
import java.util.stream.*;

public class StreamEx3 {
    public static void main(String[] args) {
        Student3[] stuArr = {
                new Student3("이자바", 3, 300),
                new Student3("김자바", 1, 200),
                new Student3("안자바", 2, 100),
                new Student3("박자바", 2, 150),
                new Student3("소자바", 1, 200)
        };

        Stream<Student3> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student3::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        stuStream = Stream.of(stuArr);
        IntStream stuScoreStream = stuStream.mapToInt(Student3::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("stat.getCount() = " + stat.getCount());
        System.out.println("stat.getSum() = " + stat.getSum());
        System.out.println("stat.getAverage() = " + stat.getAverage());
        System.out.println("stat.getMin() = " + stat.getMin());
        System.out.println("stat.getMax() = " + stat.getMax());

    }
}

class Student3 implements Comparable<Student3> {
    String name;
    int ban;
    int totalScore;

    public Student3(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
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

    @Override
    public int compareTo(Student3 o) {
        return o.ban - this.ban;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return String.format ("[%s, %d, %d]", name, ban, totalScore);
    }
}
