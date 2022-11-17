public class Employee extends Student {
    private final int wage;

    public Employee(String name, int age, String university, int wage) {
        super(name, age, university);
        this.wage = wage;
    }

    public int getWage() {
        return wage;
    }
}
