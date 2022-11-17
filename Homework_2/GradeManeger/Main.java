import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Peter Parker");
        Student student2 = new Student("Tony Stark");
        Student student3 = new Student("Steve Rogers");

        Student[] students = new Student[]{student1, student2, student3};

        System.out.println("Hello, my dear friend, this is my GradeManager.");
        System.out.println("These are all the available commands:");
        getCommands();

        Scanner in = new Scanner(System.in);
        String input = "";

        while (!Objects.equals(input, "/q")) {

            System.out.print("Input the command: ");
            input = in.nextLine();
            System.out.println();

            //     "/r"
            if (Objects.equals(input, "/r")) {
                int randStudent = getRandomStudent(students.length);
                System.out.println(students[randStudent].getName());
                System.out.print("Grade: ");
                int grade = -1;
                try {
                    grade = Integer.parseInt(in.nextLine());
                    if (grade < 0 || grade > 10) {
                        System.out.println("Incorrect grade. Grade can be only from 0 to 10.\n");
                    } else {
                        students[randStudent].addGrade(grade);
                    }
                    System.out.println();
                } catch (NumberFormatException ex) {
                    System.out.println("Incorrect grade. Grade can be only from 0 to 10.\n");
                }

                //   "/p"
            } else if (Objects.equals(input, "/p")) {
                for (Student student : students) {
                    if (student.getGrade() == 0) {
                        System.out.println(student.getName() + " " + "-");
                    } else {
                        System.out.println(student.getName() + " " + student.getGrade());
                    }
                }
                System.out.println();

                //    "/q"
            } else if (Objects.equals(input, "/q")) {
                return;
            } else {
                System.out.println("Incorrect command, try again.\n");
            }
        }
    }

    public static void getCommands() {
        System.out.println("-------------------------");
        System.out.println("/r - get random student.");
        System.out.println("/p - get all students and their grades.");
        System.out.println("/q - quit.");
        System.out.println("-------------------------");
    }

    public static int getRandomStudent(int studentsCount) {
        return (int) (Math.random() * studentsCount);
    }
}
