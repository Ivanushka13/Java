public class Student {
    private final String name;
    private int grade;
    private int gradeCount;

    public Student(String name) {
        this.name = name;
        grade = 0;
        gradeCount = 0;
    }

    public String getName() {
        return name;
    }

    // Функция будет выводить среднюю по всем полученным оценкам
    public void addGrade(int grade) {
        if (this.grade == 0) {
            this.grade = grade;
            gradeCount = 1;
        } else {
            gradeCount += 1;
            this.grade = (this.grade + grade) / gradeCount;
        }
    }

    public int getGrade() {
        return grade;
    }
}
