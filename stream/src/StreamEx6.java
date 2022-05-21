import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class StreamEx6 {
    public static void main(String[] args) {
        Student6[] stuArr = {
                new Student6("이자바", 3, 300),
                new Student6("김자바", 1, 200),
                new Student6("안자바", 2, 100),
                new Student6("박자바", 2, 150),
                new Student6("소자바", 1, 200),
                new Student6("나자바", 3, 290),
                new Student6("감자바", 3, 180)
        };

        // 학생 이름만 뽑아서 List<Stiring>에 저장
        List<String> names = Stream.of(stuArr).map(Student6::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        // 스트림을 배열로 변환
        Student6[] stuArr2 = Stream.of(stuArr).toArray(Student6[]::new);

        for (Student6 s : stuArr2) {
            System.out.println(s);
        }

        // 스트림을 Map<String, Student6>로 변환. 학생 이름이 key
        Map<String, Student6> stuMap = Stream.of(stuArr)
                .collect(Collectors.toMap(s -> s.getName(), p->p));

        for (String name : stuMap.keySet())
            System.out.println(name + "-" + stuMap.get(name));

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr)
                .collect(summingInt(Student6::getTotalScore));
        System.out.println("count = " + count);
        System.out.println("totalScore = " + totalScore);

        totalScore = Stream.of(stuArr)
                .collect(reducing(0, Student6::getTotalScore, Integer::sum));
        System.out.println("totalScore = " + totalScore);

        Optional<Student6> topStudent = Stream.of(stuArr)
                .collect(maxBy(Comparator.comparingInt(Student6::getTotalScore)));
        System.out.println("topStudent = " + topStudent);

        IntSummaryStatistics stat = Stream.of(stuArr)
                .collect(summarizingInt(Student6::getTotalScore));
        System.out.println("stat = " + stat);

        String stuNames = Stream.of(stuArr).map(Student6::getName)
                .collect(joining(",", "{", "}"));
        System.out.println("stuNames = " + stuNames);
    }
}

class Student6 implements Comparable<Student6> {
    String name;
    int ban;
    int totalScore;

    public Student6(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
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
    public int compareTo(Student6 o) {
        return o.totalScore - this.totalScore;
    }
}
