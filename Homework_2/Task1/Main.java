public class Main {
    public static void main(String[] args) {

        Person person = new Person("Ivan", 20);
        Student student = new Student("Grisha", 21, "HSE");
        Employee employee = new Employee("Egor", 25, "MSU", 10000);

        System.out.println(person.getName() + " " + person.getAge());

        System.out.println(student.getName() + " " + student.getAge() + " " + student.getUniversity());

        System.out.println(employee.getName() + " " + employee.getAge() + " " + employee.getUniversity()
                + " " + employee.getWage());
    }
}
