import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Student7 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;

    public Student7(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student7{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", hak=" + hak +
                ", ban=" + ban +
                ", score=" + score +
                '}';
    }
    // groupingBy()에 사용
    enum Level { HIGH, MID, LOW } // 성적을 상, 중, 하 3단계로 분류
}
public class StreamEx7 {
    public static void main(String[] args) {
        Student7[] stuArr = {
                new Student7("나자바", true, 1, 1, 300),
                new Student7("김지미", false, 1, 1, 250),
                new Student7("나자바", true, 1, 1, 200),
                new Student7("이지미", false, 1,2, 150),
                new Student7("남자바", true, 1,2, 100),
                new Student7("안지미", false, 1, 2, 50),
                new Student7("황지미", false, 1, 3, 100),
                new Student7("강자바", true, 1, 3, 150),

                new Student7("나자바", true, 2, 1, 300),
                new Student7("김지미", false,2, 1, 250),
                new Student7("나자바", true, 2, 1, 200),
                new Student7("이지미", false, 2,2, 150),
                new Student7("남자바", true, 2,2, 100),
                new Student7("안지미", false, 2, 2, 50),
                new Student7("황지미", false, 2, 3, 100),
                new Student7("강자바", true, 2, 3, 150)
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student7>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale));

        List<Student7> maleStudent7 = stuBySex.get(true);
        List<Student7> femaleStudent7 = stuBySex.get(false);

        for (Student7 s : maleStudent7) {
            System.out.println(s);
        }
        for (Student7 s : femaleStudent7) {
            System.out.println(s);
        }

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale, counting()));

        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student7>> topOptionalStudent7BySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale,
                        maxBy(comparingInt(Student7::getScore))
                ));
        System.out.println("남학생 1등 : " + topOptionalStudent7BySex.get(true));
        System.out.println("여학생 1등 : " + topOptionalStudent7BySex.get(false));

        Map<Boolean, Student7> topStudent7BySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(Student7::getScore)), Optional::get
                        )
                ));
        System.out.println("남학생 1등 : " + topStudent7BySex.get(true));
        System.out.println("여학생 1등 : " + topStudent7BySex.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");
        Map<Boolean, Map<Boolean, List<Student7>>> failedStuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student7::isMale,
                        partitioningBy(s -> s.getScore() <= 100)
                ));
        List<Student7> faileMaleStu = failedStuBySex.get(true).get(true);
        List<Student7> faileFemaleStu = failedStuBySex.get(false).get(true);

        for (Student7 s : faileMaleStu) {
            System.out.println(s);
        }
        for (Student7 s : faileFemaleStu) {
            System.out.println(s);
        }
    }
}
