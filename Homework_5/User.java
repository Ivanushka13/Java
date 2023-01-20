import java.util.Objects;

public final class User {
    private long id;

    private String firstName;

    private String lastName;

    private int age;

    private String nationality;

    public User(long id, String firstName, String lastName, int age, String nationality) {
        if(id < 0 ) {
            throw new IllegalArgumentException("Id must be non negative.");
        }
        if(age < 0) {
            throw new IllegalArgumentException("Age must be non negative.");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setId(long id) {
        if(id < 0 ) {
            throw new IllegalArgumentException("Id must be non negative.");
        }

        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Age must be non negative.");
        }

        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;

        return this.id == user.getId()
                && Objects.equals(this.firstName, user.getFirstName())
                && Objects.equals(this.lastName, user.getLastName())
                && this.age == user.getAge()
                && Objects.equals(this.nationality, user.getNationality());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
